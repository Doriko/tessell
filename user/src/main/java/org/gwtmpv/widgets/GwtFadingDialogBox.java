package org.gwtmpv.widgets;

import com.google.gwt.user.client.ui.FadingDialogBox;
import com.google.gwt.user.client.ui.Widget;

public class GwtFadingDialogBox extends FadingDialogBox implements IsFadingDialogBox {

  @Override
  public void setWidget(final IsWidget isWidget) {
    setWidget(isWidget.asWidget());
  }

  @Override
  public void add(final IsWidget isWidget) {
    add(isWidget.asWidget());
  }

  @Override
  public boolean remove(final IsWidget isWidget) {
    return remove(isWidget.asWidget());
  }

  @Override
  public Widget asWidget() {
    return this;
  }

  @Override
  public IsStyle getStyle() {
    return getIsElement().getStyle();
  }

  @Override
  public IsElement getIsElement() {
    return new GwtElement(getElement());
  }

}
