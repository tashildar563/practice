### What is a stream pipeline? name its parts and why laziness matters.
1. Source (collection, array, files.lines, generator),
2. Intermediate operations (filter,map,sorted) which are lazy and return a stream and 
3. terminal operation (collect, reduce, forEach) which triggers evaluation. laziness enables fusion and short circuit (limit, anyMatch) for performance.
4. Internal working
   1. java processess elements one at a time
   2. stops as soon as it finds the first match.
   3. does not process the whole list
   ```mermaid
    stateDiagram
   take_one_item --> filter 
   filter --> map
   map --> result
   result --> next
   ```
   
### what is encounter order ? how do forEach and forEachOrdered differ
* what is encounter order : it is the natural order in which a streams source gives elements
* so if the source is ordered, streams try to respect that order unless told otherwise
  * forEach vs forEachOrdered
    1. forEach
        * runs the action on each element
        * on sequential stream -> preserves encounter order.
        * on parallel streams -> may ignore order for performace
    2. forEachOrdered
        * always respects encounter order, even in parallel streams.
        * but slower because it waits and arranges results in the correct order.
### what does "non-interfenence" and statelessness mean? why avoid side effects?
1. Non interference 
    * stream operations must not change the source while the pipeline is running.
    * why? because streams traverse the data once in a predicatable way.
    * if the source changes mid-traversal -> unpredictable result or exceptions
2. Statelessness
   * each element's processing should not depend on external mutable state or on prevous elements.
   * the function must behave the same every time for the same input.

### 
   