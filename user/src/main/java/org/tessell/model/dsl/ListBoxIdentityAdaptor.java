package org.tessell.model.dsl;

public class ListBoxIdentityAdaptor<P> implements ListBoxAdaptor<P, P> {

  @Override
  public String toDisplay(P option) {
    return option == null ? "" : option.toString();
  }

  @Override
  public P toValue(P option) {
    return option;
  }

}
