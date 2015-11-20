public class SelectionSort
{
  /**
   * Sorts a[0], ..., a[size-1] in ascending order
   *   using Selection Sort
   */
  public static void sort(double a[])
  {
    int i, iMax, n;
    double aTemp;

    for (n = a.length; n >= 2; n--)
    {

      // Find the index iMax of the largest element
      //   among a[0], ..., a[n-1]:

      iMax = 0;
      for (i = 1; i < n; i++)
        if (a[i] > a[iMax])
          iMax = i;

      // Swap a[iMax] with a[n-1]:

      aTemp = a[iMax];    // Save a[iMax] in a temporary location.
      a[iMax] = a[n-1];   // Copy a[n-1] to a[iMax].
      a[n-1] = aTemp;     // Copy saved value to a[n-1].

      // Decrement n (accomplished by n-- in the for loop).
    }
  }
}

