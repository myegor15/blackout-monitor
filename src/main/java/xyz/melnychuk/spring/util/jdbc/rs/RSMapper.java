package xyz.melnychuk.spring.util.jdbc.rs;

@FunctionalInterface
public interface RSMapper<T> {
    T mapRow(RSGetter rsGetter);
}
