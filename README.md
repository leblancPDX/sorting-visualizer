# Sorting-Visualizer
Simple sorting algorithm visualizer written in Kotlin.

![Class Diagram](sorting-visualizer-diagram.png)

## Overview

This project was created as a teaching aid for an introduction to algorithms course. Each sorting algorithm can use any of the including ordering logic implementations. The algorithms sort a special monitored array. Any element updates or swaps trigger any registered listeners.

## Sorting Algorithms
All sorting algorithms implement the `sort` method, which takes an array to be sorted and the ordering logic.

### Supported Algorithms
#### Insertion Sort
#### Selection Sort

### Ordering Logic
The sorting algorithm uses an ordering logic that is applied through the strategy pattern so that it can be easily swapped during runtime.

## Monitored Array
The sorts are applied to a monitored array object. Changes to the array trigger an update on the registered listeners, which can then render the array changes.

## Array Listeners
All listeners implement the `update` method and respond to changes to the array by creating some visualization step so that the sorting process can be observed.

### Console Array Printer
At each step in the sorting process the array is printed to the console.