package org.gwtmpv.widgets.form.lines;

import static org.gwtmpv.widgets.Widgets.newTextList;

import org.gwtmpv.model.dsl.Binder;
import org.gwtmpv.model.properties.Property;
import org.gwtmpv.util.HTMLPanelBuilder;
import org.gwtmpv.util.Inflector;
import org.gwtmpv.widgets.IsTextBox;
import org.gwtmpv.widgets.IsTextList;

/** Adds a {@link IsTextBox} to a form. */
public abstract class TextBoxBaseFormLine implements FormLine {

  private String id;
  private final Property<String> property;
  private final IsTextBox textBox;
  private final IsTextList errorList = newTextList();

  public TextBoxBaseFormLine(Property<String> property, IsTextBox textBox) {
    this.property = property;
    this.textBox = textBox;
  }

  @Override
  public void bind(String formId, Binder binder) {
    id = formId + "-" + Inflector.camelize(property.getName());
    textBox.getIsElement().setId(id);
    binder.bind(property).to(textBox, errorList);
  }

  @Override
  public void renderLabel(HTMLPanelBuilder hb) {
    hb.add("<label for=\"" + id + "\">");
    hb.add(property.getName());
    hb.add("</label>");
  }

  @Override
  public void renderValue(HTMLPanelBuilder hb) {
    hb.add(textBox);
    hb.add(errorList);
  }

  public IsTextBox getTextBox() {
    return textBox;
  }

  public IsTextList getErrorList() {
    return errorList;
  }

}
