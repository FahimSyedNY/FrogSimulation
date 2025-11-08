public class FrogSimulation
{
    /** Distance, in inches, from the starting position to the goal. */
    private int goalDistance;
    /** Maximum number of hops allowed to reach the goal. */
    private int maxHops;

    /** Constructs a FrogSimulation where dist is the distance, in inches, from the starting
     * position to the goal, and numHops is the maximum number of hops allowed to reach the goal.
     * Precondition: dist > 0; numHops > 0
     */
    public FrogSimulation(int dist, int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }
    /** Returns an integer in the range -100 - 100 representing the distance, in inches, to be moved when the frog hops.
     */
    private int hopDistance() {
        return (int) (Math.random() * 201 - 100);
    }

    /** Simulates a frog attempting to reach the goal as described in part (a).
     * Returns true if the frog successfully reached or passed the goal during the simulation;
     * false otherwise.
     */
    public boolean simulate() {
        int pos = 0;
        for (int i = 0; i < maxHops; i++) {
            pos += hopDistance();
            if (pos >= goalDistance) {
                return true;
            }
        }
        return false;
    }

    /** Runs num simulations and returns the proportion of simulations in which the frog
     * successfully reached or passed the goal.
     * Precondition: num > 0
     */
    public String runSimulations(int num) {
        int won = 0;
        int lost = 0;
        for (int i = 0; i < num; i++) {
            if (simulate()) won++; else lost++;
        }
        return ("Won: " + won + " Lost: " + lost + "\n" + won / gcd(won, lost)) + ":" + (lost / gcd(won, lost) + "\nPercent won: " + ((double) won * 100 / num) + "%");
    }
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}