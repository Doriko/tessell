package org.gwtmpv.tests.model.dsl;

import static org.gwtmpv.model.properties.NewProperty.stringProperty;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.gwtmpv.model.dsl.Binder;
import org.gwtmpv.model.properties.StringProperty;
import org.gwtmpv.widgets.StubTextBox;
import org.junit.Test;

public class BinderTest {

  final Binder binder = new Binder(new StubCanRegisterHandlers());
  final StringProperty s = stringProperty("s");
  final StubTextBox box = new StubTextBox();

  @Test
  public void propertyToWidget() {
    binder.bind(s).to(box);
    s.set("test");
    assertThat(box.getValue(), is("test"));
  }

  @Test
  public void propertyToWidgetImmediatelySetsTheWidgetsValue() {
    s.set("test");
    binder.bind(s).to(box);
    assertThat(box.getValue(), is("test"));
  }

  @Test
  public void widgetToProperty() {
    binder.bind(s).to(box);
    box.type("test");
    assertThat(s.get(), is("test"));
  }

  @Test
  public void stringPropertyToWidgetSetsMaxLength() {
    s.max(100);
    binder.bind(s).to(box);
    assertThat(box.getMaxLength(), is(100));
  }

  @Test
  public void clickableWidgetToProperty() {
    binder.bind(s).withValue("gotclicked").to(box);
    box.click();
    assertThat(s.get(), is("gotclicked"));
  }

}