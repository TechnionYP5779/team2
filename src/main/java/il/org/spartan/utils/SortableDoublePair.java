package il.org.spartan.utils;

import fluent.ly.*;
import il.org.spartan.*;

public class SortableDoublePair implements Comparable<SortableDoublePair> {
  Pair<Double, Double> pair;

  public SortableDoublePair(double a, double b) {
    pair = new Pair<>(box.it(a), box.it(b));
  }

  public Pair<Double, Double> getPair() {
    return pair;
  }

  @Override public int compareTo(SortableDoublePair o) {
    double $ = Math.sqrt(Math.pow(unbox.unbox(Utils.cantBeNull(pair.first)), 2) + Math.pow(unbox.unbox(Utils.cantBeNull(pair.second)), 2));
    double bDist = Math
        .sqrt(Math.pow(unbox.unbox(Utils.cantBeNull(o.getPair().first)), 2) + Math.pow(unbox.unbox(Utils.cantBeNull(o.getPair().second)), 2));
    return ($ - bDist < 0) ? -1 : ($ - bDist == 0 ? 0 : 1);
  }
}