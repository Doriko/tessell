package org.gwtmpv.widgets;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;

public class StubHyperlink extends StubWidget implements IsHyperlink {

  private String targetHistoryToken;
  private String text;

  @Override
  public String getTargetHistoryToken() {
    return targetHistoryToken;
  }

  @Override
  public void setTargetHistoryToken(final String targetHistoryToken) {
    this.targetHistoryToken = targetHistoryToken;
  }

  @Override
  public String getHTML() {
    return text;
  }

  @Override
  public void setHTML(final String html) {
    text = html;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  public void setText(final String text) {
    this.text = text;
  }

  @Override
  public HandlerRegistration addClickHandler(final ClickHandler handler) {
    throw new UnsupportedOperationException("Use Anchor instead for non-History links");
  }

}
