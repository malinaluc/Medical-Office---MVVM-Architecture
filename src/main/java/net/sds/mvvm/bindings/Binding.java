package net.sds.mvvm.bindings;

/**
 * Defines a binding between a source and a target.
 */
public interface Binding {
    /**
     * Applies the binding using the given direction. If the direction is {@link Direction#UP} the binding is applied from
     * source to target. When the direction is {@link Direction#DOWN} the binding is applied from target to source.
     * @param direction
     */
    void apply(Direction direction);
}