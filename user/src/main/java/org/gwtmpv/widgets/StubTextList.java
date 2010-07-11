package org.gwtmpv.widgets;

import java.util.ArrayList;
import java.util.List;

public class StubTextList extends StubWidget implements IsTextList {

  private final List<String> list = new ArrayList<String>();
  private boolean enabled = true;

  @Override
  public void add(final String text) {
    list.add(text);
  }

  @Override
  public void remove(final String text) {
    while (list.contains(text)) {
      list.remove(text);
    }
  }

  @Override
  public void clear() {
    list.clear();
  }

  public List<String> getList() {
    return list;
  }

  @Override
  public boolean hasErrors() {
    return list.size() > 0;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }

}