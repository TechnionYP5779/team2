package il.org.spartan.tables;

import java.util.*;

import il.org.spartan.statistics.*;

/** TODO Yossi Gil Document Class
 * @author Yossi Gil
 * @since 2016-12-26 */
public enum Statistic {
  N {
    @Override public double of(final RealStatistics param) {
      return param.n();
    }
  },
  NA {
    @Override public String toString() {
      return "N/A";
    }

    @Override public double of(final RealStatistics param) {
      return param.missing();
    }
  },
  mean {
    @Override public double of(final RealStatistics param) {
      return param.mean();
    }
  },
  σ {
    @Override public double of(final RealStatistics param) {
      return param.sd();
    }
  },
  median {
    @Override public double of(final RealStatistics param) {
      return param.median();
    }
  },
  MAD {
    @Override public double of(final RealStatistics param) {
      return param.mad();
    }

    @Override public String toString() {
      return "M.A.D";
    }
  },
  min {
    @Override public double of(final RealStatistics param) {
      return param.min();
    }
  },
  max {
    @Override public double of(final RealStatistics param) {
      return param.max();
    }
  },
  range {
    @Override public double of(final RealStatistics param) {
      return param.max() - param.min();
    }
  },
  Q1 {
    @Override public double of(final RealStatistics param) {
      return quartile(25, param.all());
    }
  },
  Q3 {
    @Override public double of(final RealStatistics param) {
      return quartile(75, param.all());
    }
  },
  Σ {
    @Override public double of(final RealStatistics param) {
      return param.sum();
    }
  };
  public abstract double of(RealStatistics s);

  /** @param p percents of quartile (for q1 - 25, q3 - 75, median - 50) */
  static double quartile(final int p, final double[] ds) {
    Arrays.sort(ds);
    return ds[Math.round(p * ds.length / 100)];
  }
}
