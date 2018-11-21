package il.org.spartan.utils;

import java.util.*;

import static il.org.spartan.Utils.*;
import static fluent.ly.unbox.*;

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

  public Pair<Double, Double> at(final int ¢) {
    return list.get(¢).getPair();
  }

  public int count() {
    return list.size();
  }

  public double distSum() {
    double $ = 0;
    for (int ¢ = 0; ¢ < list.size(); ++¢)
      $ += Math.sqrt(Math.pow(unbox(cantBeNull(this.at(¢).first)), 2) + Math.pow(unbox(cantBeNull(this.at(¢).second)), 2));
    return $;
  }

  public double sum() {
    double $ = 0;
    for (int ¢ = 0; ¢ < list.size(); ++¢)
      $ += unbox(cantBeNull(this.at(¢).first)) + unbox(cantBeNull(this.at(¢).second));
    return $;
  }
}
