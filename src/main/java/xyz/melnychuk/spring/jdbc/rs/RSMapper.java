package xyz.melnychuk.spring.jdbc.rs;

@FunctionalInterface
public interface RSMapper<T> {
    T mapRow(RSGetter rsGetter);
}
