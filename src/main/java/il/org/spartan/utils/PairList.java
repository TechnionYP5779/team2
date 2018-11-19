package il.org.spartan.utils;

import java.util.*;

import fluent.ly.*;
import il.org.spartan.*;

public class PairList {
  List<SortableDoublePair> list;

  public PairList() {
    list = new ArrayList<>();
  }

  public void record(final double d, final double e) {
    list.add(new SortableDoublePair(d, e));
  }

  public void sort() {
    list.sort(null);
  }

  public ListIterator<SortableDoublePair> sortedIterator() {
    this.sort();
    return list.listIterator();
  }

  public Pair<Double, Double> at(final int i) {
    return list.get(i).getPair();
  }

  public int count() {
    return list.size();
  }

  public double distSum() {
    double $ = 0;
    for (int ¢ = 0; ¢ < list.size(); ++¢)
      $ += Math.sqrt(Math.pow(unbox.unbox(Utils.cantBeNull(this.at(¢).first)), 2) + Math.pow(unbox.unbox(Utils.cantBeNull(this.at(¢).second)), 2));
    return $;
  }

  public double sum() {
    double $ = 0;
    for (int ¢ = 0; ¢ < list.size(); ++¢)
      $ += unbox.unbox(Utils.cantBeNull(this.at(¢).first)) + unbox.unbox(Utils.cantBeNull(this.at(¢).second));
    return $;
  }
}
