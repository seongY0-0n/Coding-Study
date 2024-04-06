namespace Solution {
  class Program {
    static void Main(string[] args) {

      while (true) {
        var n = int.Parse(Console.ReadLine()!);

        if (n == 0) break;

        var totalBlocks = n * (n + 1) / 2;
        Console.WriteLine(totalBlocks);
      }
    }
  }
}