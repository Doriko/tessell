package org.gwtmpv.widgets;

public interface IsPanel extends IsWidget, HasIsWidgets {

  void add(IsWidget isWidget);

  boolean remove(IsWidget isWidget);

}
