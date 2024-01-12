package com.kpzip.circuitsapi.circuitsim.components;

import java.util.function.BiFunction;

import com.kpzip.circuitsapi.circuitsim.Circuit;

@FunctionalInterface
public interface BiNodeComponentSupplier<C extends Component> extends BiFunction<Circuit.ConnectionPoint, Circuit.ConnectionPoint, C> {

}
