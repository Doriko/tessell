package org.gwtmpv.widgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubHTMLPanel extends StubComplexPanel implements IsHTMLPanel {

  private final String html;
  private final Map<String, IsWidget> replaced = new HashMap<String, IsWidget>();
  private final List<IsWidget> placed = new ArrayList<IsWidget>();

  public StubHTMLPanel() {
    html = null;
  }

  public StubHTMLPanel(String html) {
    this.html = html;
  }

  @Override
  public void add(IsWidget widget, IsElement elem) {
    placed.add(widget);
  }

  public String getHtml() {
    return html;
  }

  @Override
  public void addAndReplaceElement(IsWidget widget, IsElement elem) {
    add(widget);
  }

  @Override
  public void addAndReplaceElement(IsWidget widget, String id) {
    add(widget);
    replaced.put(id, widget);
  }

  public IsWidget getPlaced(int index) {
    return placed.get(index);
  }

  public IsWidget getReplaced(String id) {
    IsWidget w = replaced.get(id);
    if (w == null) {
      throw new IllegalArgumentException("Could not find " + id);
    }
    return w;
  }

}
