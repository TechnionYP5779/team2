package il.org.spartan.utils;

import java.util.*;

import fluent.ly.*;
import il.org.spartan.*;

public class PairList {
  List<SortableDoublePair> list;

  public PairList() {
    list = new ArrayList<>();
  }

  public void record(double d, double e) {
    list.add(new SortableDoublePair(d, e));
  }

  public void sort() {
    list.sort(null);
  }

  public ListIterator<SortableDoublePair> sortedIterator() {
    this.sort();
    return list.listIterator();
  }

  public Pair<Double, Double> at(int i) {
    return list.get(i).getPair();
  }

  public int count() {
    return list.size();
  }

  public double distSum() {
    double sum = 0;
    for (int i = 0; i < list.size(); i++) {
      sum += Math.sqrt(Math.pow(unbox.unbox(Utils.cantBeNull(this.at(i).first)), 2) + Math.pow(unbox.unbox(Utils.cantBeNull(this.at(i).second)), 2));
    }
    return sum;
  }

  public double sum() {
    double sum = 0;
    for (int i = 0; i < list.size(); i++) {
      sum += unbox.unbox(Utils.cantBeNull(this.at(i).first)) + unbox.unbox(Utils.cantBeNull(this.at(i).second));
    }
    return sum;
  }
}
