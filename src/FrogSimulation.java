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
    /** Returns an integer representing the distance, in inches, to be moved when the frog hops.
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
    public double runSimulations(int num) {
        double won = 0;
        double lost = 0;
        for (int i = 0; i < num; i++) {
            if (simulate()) won++; else lost++;
        }
        System.out.println("Won: " + won + " Lost: " + lost);
        return (won / lost);
    }
}