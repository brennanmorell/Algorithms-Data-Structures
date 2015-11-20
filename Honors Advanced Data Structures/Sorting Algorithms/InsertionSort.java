public class InsertionSort
{
  /**
   * Sorts a[0], ..., a[size-1] in ascending order
   *   using Insertion Sort
   */
  public static void sort(double a[])
  {
    int i, iMax, n;
    double aTemp;

    for (n = 1; n < a.length; n++)
    {
      // Save the next element to be inserted:

      aTemp = a[n];

      // Going backwards from a[n-1], shift elements to the
      //   right until you find an element a[i] <= aTemp:

      i = n;
      while (i > 0 && aTemp < a[i-1])
      {
        a[i] = a[i-1];
        i--;
      }

      // Insert the saved element after a[i]:
      a[i] = aTemp;

      // Increment n (accomplished by n++ in the for loop).
    }
  }
}

