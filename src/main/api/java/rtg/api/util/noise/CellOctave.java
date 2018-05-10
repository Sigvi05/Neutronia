package rtg.api.util.noise;

/**
 * @author Zeno410
 */
public interface CellOctave {
    float noise(double x, double z, double depth);

    VoronoiResult eval(double x, double y);
}
