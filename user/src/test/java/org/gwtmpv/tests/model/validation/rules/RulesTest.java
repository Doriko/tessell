package org.gwtmpv.tests.model.validation.rules;

import static org.gwtmpv.model.properties.NewProperty.booleanProperty;
import static org.gwtmpv.model.properties.NewProperty.stringProperty;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang.StringUtils;
import org.gwtmpv.model.properties.BooleanProperty;
import org.gwtmpv.model.properties.StringProperty;
import org.gwtmpv.model.validation.Valid;
import org.gwtmpv.model.validation.rules.Custom;
import org.gwtmpv.model.validation.rules.Length;
import org.gwtmpv.model.validation.rules.Required;
import org.gwtmpv.model.values.SetValue;
import org.junit.Before;
import org.junit.Test;

public class RulesTest extends AbstractRuleTest {

  public static class Foo {
    public StringProperty name = stringProperty("name");
    public StringProperty description = stringProperty("description");
  }

  private final Foo f = new Foo();

  @Before
  public void listenToName() {
    listenTo(f.name);
  }

  @Test
  public void whenRuleIsValidatedTheStateIsRemembered() {
    new Required(f.name, "name required");
    new Length(f.name, "name length");

    assertThat(f.name.wasValid(), nullValue());
    f.name.set(null);
    assertThat(f.name.wasValid(), is(Valid.NO));
  }

  @Test
  public void whenMultiplesRulesPerPropertyOnlyTheFirstFires() {
    new Required(f.name, "name required");
    new Length(f.name, "name length");

    f.name.set(null);
    assertMessages("name required");
  }

  @Test
  public void whenMultipleRulesPerPropertyTheSecondCanFireNext() {
    new Required(f.name, "name required");
    new Length(f.name, "name length");

    f.name.set(StringUtils.repeat("a", 101));
    assertMessages("name length");
    // back to a good value
    f.name.set("good value");
    assertMessages("");
  }

  @Test
  public void reassessingReValidatesForCustomRules() {
    final SetValue<Boolean> customLogic = new SetValue<Boolean>("customLogic");
    customLogic.set(true);

    new Custom(f.name, "custom", customLogic);
    f.name.set("a name");
    assertMessages("");

    // just changing the logic has no way of revalidating
    customLogic.set(false);
    assertMessages("");

    // but reassessing should
    f.name.reassess();
    assertMessages("custom");
  }

  @Test
  public void untouchingUntriggersTheRule() {
    new Required(f.name, "name required");

    f.name.set(null);
    assertMessages("name required");

    f.name.setTouched(false);
    assertMessages("");
  }

  @Test
  public void onlyIfDoesNotTouchDownstreamRules() {
    final BooleanProperty b = booleanProperty("b", false);
    new Required(f.name, "name required").onlyIf(b);

    b.set(true);
    assertMessages("");

    f.name.touch();
    assertMessages("name required");
  }

}