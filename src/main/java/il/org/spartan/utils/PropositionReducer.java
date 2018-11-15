package il.org.spartan.utils;

import java.util.function.*;

import il.org.spartan.utils.Proposition.*;

/** TODO Yossi Gil: document class
 * @param <R>
 * @author Yossi Gil
 * @since 2017-03-19 */
public abstract class PropositionReducer<R> extends Reduce<R> {
  public PropositionReducer(final Reduce<R> inner) {
    this.inner = inner;
    assert inner != this;
  }

  @Override public R reduce() {
    return inner.reduce();
  }

  public final R reduce(final BooleanSupplier param) {
    return //
    param instanceof Not ? reduce((Not) param) //
        : param instanceof Singleton ? reduce((Singleton) param) //
            : param instanceof And ? reduce((And) param) //
                : param instanceof Or ? reduce((Or) param) //
                    : map(param);
  }

  @Override public R reduce(final R r1, final R r2) {
    return inner.reduce(r1, r2);
  }

  private R reduce(final And a) {
    R $ = ante(a);
    for (int size = a.inner.size(), ¢ = 0; ¢ < size; ++¢) {
      $ = reduce($, reduce(a.inner.get(¢)));
      if (¢ < size - 1)
        $ = reduce($, inter(a));
    }
    return reduce($, post(a));
  }

  private R reduce(final Not param) {
    return reduce(ante(param), reduce(param.inner), post(param));
  }

  private R reduce(final Singleton param) {
    return reduce(ante(param), map(param), post(param));
  }

  private R reduce(final Or o) {
    R $ = ante(o);
    for (int size = o.inner.size(), ¢ = 0; ¢ < size; ++¢) {
      $ = reduce($, reduce(o.inner.get(¢)));
      if (¢ < size - 1)
        $ = reduce($, inter(o));
    }
    return reduce($, post(o));
  }

  protected R ante(@SuppressWarnings("unused") final Proposition.Not __) {
    return reduce();
  }

  protected R ante(@SuppressWarnings("unused") final Proposition.Singleton __) {
    return reduce();
  }

  protected R ante(@SuppressWarnings("unused") final Some __) {
    return reduce();
  }

  protected R inter(@SuppressWarnings("unused") final And __) {
    return reduce();
  }

  protected R inter(@SuppressWarnings("unused") final Or __) {
    return reduce();
  }

  protected abstract R map(BooleanSupplier ¢);

  protected R post(@SuppressWarnings("unused") final Proposition.Not __) {
    return reduce();
  }

  protected R post(@SuppressWarnings("unused") final Proposition.Singleton __) {
    return reduce();
  }

  protected R post(@SuppressWarnings("unused") final Some __) {
    return reduce();
  }

  public final Reduce<R> inner;
}