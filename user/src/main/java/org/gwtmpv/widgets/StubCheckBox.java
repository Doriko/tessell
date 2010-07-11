package org.gwtmpv.widgets;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;

public class StubCheckBox extends StubButtonBase implements IsCheckBox {

  private String name;
  private Boolean value;

  @Override
  public void click() {
    super.click();
    final Boolean newValue = (value == null) ? true : !value;
    setValue(newValue, true);
  }

  public void set(final Boolean value) {
    setValue(value, true);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public Boolean getValue() {
    return value;
  }

  @Override
  public void setValue(final Boolean value) {
    this.value = value;
  }

  @Override
  public void setValue(final Boolean value, final boolean fireEvents) {
    final Boolean oldValue = this.value;
    this.value = value;
    if (fireEvents) {
      ValueChangeEvent.fireIfNotEqual(this, oldValue, value);
    }
  }

  @Override
  public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Boolean> handler) {
    return handlers.addHandler(ValueChangeEvent.getType(), handler);
  }

}