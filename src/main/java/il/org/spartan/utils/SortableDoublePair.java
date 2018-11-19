package il.org.spartan.utils;

import fluent.ly.*;
import il.org.spartan.*;

public class SortableDoublePair implements Comparable<SortableDoublePair> {
  Pair<Double, Double> pair;

  public SortableDoublePair(final double a, final double b) {
    pair = new Pair<>(box.it(a), box.it(b));
  }

  public Pair<Double, Double> getPair() {
    return pair;
  }

  @Override public int compareTo(final SortableDoublePair p) {
    final double $ = Math.sqrt(Math.pow(unbox.unbox(Utils.cantBeNull(pair.first)), 2) + Math.pow(unbox.unbox(Utils.cantBeNull(pair.second)), 2));
    final double bDist = Math
        .sqrt(Math.pow(unbox.unbox(Utils.cantBeNull(p.getPair().first)), 2) + Math.pow(unbox.unbox(Utils.cantBeNull(p.getPair().second)), 2));
    return $ - bDist < 0 ? -1 : $ - bDist != 0 ? 1 : 0;
  }
}