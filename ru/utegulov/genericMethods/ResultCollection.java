package ru.utegulov.genericMethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@FunctionalInterface
public interface  ResultCollection<P>  {

    P create();
}
