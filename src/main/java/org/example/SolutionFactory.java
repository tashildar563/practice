package org.example;

import org.example.array.*;
import org.example.array.slidingWindow.CountSubstringWithKDistinctCharacters;
import org.example.cses.WeirdAlgorithm;
import org.example.llinkedlist.DeleteDuplicatesFromSortedLinkedList;
import org.example.llinkedlist.DetectCycleInLinkedList;
import org.example.llinkedlist.MiddleNodeinaLinkedList;
import org.example.llinkedlist.PrintTheMiddleOfaGivenLinkedList;
import org.example.llinkedlist.ProgramforNthnodefromtheendofaLinkedList;
import org.example.llinkedlist.RemoveDuplicateFromLinkedList2;
import org.example.llinkedlist.ReverseLinkedList;
import org.example.llinkedlist.ReverseTheLinkedList;
import org.example.llinkedlist.RotateALinkedList;
import org.example.sortingAlgo.BubbleSort;
import org.example.sortingAlgo.MergeSort;
import org.example.tree.BreadthFirstSearchTraversal;
import org.example.tree.DepthFirstTraversal;
import org.example.twopointers.MoveAllZerosToEndOfTheArray;
import org.example.twopointers.RemoveAllOccurenceOfAnelementFromArray;
import org.example.userManagementSystem.Organisation;

public class SolutionFactory {

  public static Solution createSolution(int n) {
    switch (n) {
      case 1:
        return new MultiplicationTable();
      case 2:
        return new SeriesAP();
      case 3:
        return new SeriesGP();
      case 4:
        return new ClosentNumber();
      case 5:
        return new ArmstrongNumbers();
      case 6:
        return new ReverseDigit();
      case 7:
        return new PrinttheKthDigit();
      case 8:
        return new BinaryNumbertoDecimalNumber();
      case 9:
        return new DecimalNumberToBinaryNumber();
      case 10:
        return new PrintTheMiddleOfaGivenLinkedList();
      case 11:
        return new ReverseTheLinkedList();
      case 12:
        return new RotateALinkedList();
      case 13:
        return new MaximumConsecutiveOnesinaBinaryArray();
      case 14:
        return new MoveZerosToEnd();
      case 15:
        return new RotateArrayByD();
      case 16:
        return new TrappingRainWaterProblem();
      case 17:
        return new BinarySearch();
      case 18:
        return new Organisation();
      case 19:
        return new BubbleSort();
      case 20:
        return new MergeSort();
      case 21:
        return new RemoveAllOccurenceOfAnelementFromArray();
      case 22:
        return new MoveAllZerosToEndOfTheArray();
      case 23:
        return new TwoSum();
      case 24:
        return new LongestPalindromicSubstring();
      case 25:
        return new ContainerWithMostWater();
      case 26:
        return new ThreeSum();
      case 27:
        return new LongestSubstringWithoutRepeatingCharacters();
      case 28:
        return new CoinChange();
      case 29:
        return new DeleteDuplicatesFromSortedLinkedList();
      case 30:
        return new LongestSubstringWithAtLeastKRepeatingCharacters();
      case 31:
        return new KthSmallestElementinaBST();
      case 32:
        return new RemoveDuplicateLetters();
      case 33:
        return new MiddleNodeinaLinkedList();
      case 34:
        return new ReverseLinkedList();
      case 35:
        return new ProgramforNthnodefromtheendofaLinkedList();
      case 36:
        return new SearchinRotatedSortedArray();
      case 37:
        return new RemoveDuplicateFromLinkedList2();
      case 38:
        return new MinimumWindowSubstring();
      case 39:
        return new AllCombinationOfString();
      case 40:
        return new DepthFirstTraversal();
      case 41:
        return new BreadthFirstSearchTraversal();
      case 42:
        return new CountSubstringWithKDistinctCharacters();
      case 43:
        return new StreamPractice();
      case 44:
        return new NumberOfIsLands();
      case 45:
        return new FindFirstandLastPositionofElementinSortedArray();
      case 46:
        return new GroupTheSenetencethatContainsExactSameSet();
      case 47:
        return new BestTimeToBuyAndSell();
      case 48:
        return new PringOddEvenUsingTwoThreads();
      case 49:
        return new RemoveTwoConsicutiveCharacter();
      case 50:
        return new LogicToSortIntegerListUsingQuickSort();
      case 51:
        return new BalanceBinarySearchTree();
      case 52:
        return new DetectCycleInLinkedList();
      case 53:
        return new DeleteCharactersToMakeFancyString();
      case 54:
        return new QueueUsingArray();
      case 55:
        return new BestTimeToBuyAndSellStock4();
      case 56:
        return new WeirdAlgorithm();
      case 57:
        return new BestTimeToBuyAndSellStockUsingStrategy();
      case 58:
        return new MaximumScoreFromRemovingSubstrings();
      case 59:
        return new DeleteColumnstoMakeSorted();
      case 60:
        return new DeleteColumnstoMakeSorted2();
      case 61:
        return new DeleteColumnstoMakeSorted3();
      case 62:
        return new TwoBestNonOverlappingEvents();
      case 63:
        return new AppleRedistributionintoBoxes();
      case 64:
        return new MaximizeHappinessofSelectedChildren();
      case 65:
        return new MinimumPenaltyforaShop();
      case 66:
        return new MeetingRooms_III();
      case 67:
        return new CountNegativeNumbersInaSortedMatrix();
      case 68:
        return new PascalsTriangle();
      case 69:
        return new PyramidTransitionMatrix();
      case 70:
        return new MagicSquaresInGrid();
      case 71:
        return new FruitIntoBasket();
      case 72:
        return new PlusOne();
      case 73:
        return new FruitsIntoBasketsII();
      case 74:
        return new SumofEvenNumbersAfterQueries();
      case 75:
        return new SetMismatch();
      case 76:
        return new HowManyNumbersAreSmallerThantheCurrentNumber();
      case 77:
        return new BuildanArrayWithStackOperations();
      case 78:
        return new FourDivisors();
      case 79:
        return new MaximumMatrixSum();
      default:
        return null;
    }
  }
}
