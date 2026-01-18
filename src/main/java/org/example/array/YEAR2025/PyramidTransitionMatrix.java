package org.example.array.YEAR2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.Solution;

public class PyramidTransitionMatrix implements Solution {

  /*
   * create a hashmap to get possible top blocks for the bottom left and righ pair.
   * for simulation we need to track more things the current row being fromed and current index. thus we end up with the states of recursive call. the previous string the currrent index we need to fill the current row formed till now.
   *
   * the best cases
   *   1 when we reached the bottom string having length 1, out task is over return true.
   *   2 if the index to be filled is equal to the (length of previouus row-1) means that the current row is complete. so we call for next row by making current string the previous string, taking an empty string for next row which start at index 0.
   *
   * Main body of DFS function:
   *   the possible chars for idx in curren row are given by map.
   *   we look up for bottom string's characters at (idx and idx+1) in map
   *   and call recursively for next index while appending these characters in curr row.
   *   here we are using early break to make out code optimal
   * as soon as we get true from one possibility, we need not check any other case.
   * finally we return false if we got false out of every possiblity of that pair of characters in boottom string*/
  Map<String, List<Character>> mp;

  @Override
  public void logic() {
    String bottom = "BCD";
    String[] allowed = {"BCC", "CDE", "CEA", "FFF"};
    mp = new HashMap<>();
    for (String f : allowed) {
      String key = f.substring(0, 2);
      if (!mp.containsKey(key)) {
        mp.put(key, new ArrayList<>());
      }
      mp.get(key).add(f.charAt(2));
    }
    boolean flag = fn(bottom, 0, "");
    System.out.println("flag "+ flag);
  }

  private boolean fn(String bottom, int idx, String curr) {
    if (bottom.length() == 1) {
      return true;
    }
    int n = bottom.length();
    if (idx == n - 1) {
      return fn(curr, 0, "");
    }
    String key = "" + bottom.charAt(idx) + bottom.charAt(idx + 1);
    if (!mp.containsKey(key)) {
      return false;
    }

    boolean f = false;
    for (char ch : mp.get(key)) {
      f |= fn(bottom, idx + 1, curr + ch);
      if (f) {
        return true;
      }
    }
    return f;
  }

  @Override
  public String description() {
    return "69 Pyramid Transition Matrix";
  }

  @Override
  public String problemStatement() {
    return "You are stacking blocks to form a pyramid. Each block has a color, which is represented by a single letter. Each row of blocks contains one less block than the row beneath it and is centered on top.\n"
        + "\n"
        + "To make the pyramid aesthetically pleasing, there are only specific triangular patterns that are allowed. A triangular pattern consists of a single block stacked on top of two blocks. The patterns are given as a list of three-letter strings allowed, where the first two characters of a pattern represent the left and right bottom blocks respectively, and the third character is the top block.\n"
        + "\n"
        + "For example, \"ABC\" represents a triangular pattern with a 'C' block stacked on top of an 'A' (left) and 'B' (right) block. Note that this is different from \"BAC\" where 'B' is on the left bottom and 'A' is on the right bottom.\n"
        + "You start with a bottom row of blocks bottom, given as a single string, that you must use as the base of the pyramid.\n"
        + "\n"
        + "Given bottom and allowed, return true if you can build the pyramid all the way to the top such that every triangular pattern in the pyramid is in allowed, or false otherwise.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "\n"
        + "Input: bottom = \"BCD\", allowed = [\"BCC\",\"CDE\",\"CEA\",\"FFF\"]\n"
        + "Output: true\n"
        + "Explanation: The allowed triangular patterns are shown on the right.\n"
        + "Starting from the bottom (level 3), we can build \"CE\" on level 2 and then build \"A\" on level 1.\n"
        + "There are three triangular patterns in the pyramid, which are \"BCC\", \"CDE\", and \"CEA\". All are allowed.";
  }
}
