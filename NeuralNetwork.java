public class NeuralNetwork 
{

    public static void main(String[] args) 
    {
        
        float[][] data = 
        {
            {1.0f, 0.0f, 1.0f},
            {2.0f, 1.0f, 9.0f},
            {0.0f, 1.0f, 1.0f},
            {-2.0f, 1.0f, 7.0f}
        };

        float w1 = 0.5f;
        float w2 = 0.5f;

        float learningRate = 0.01f;

        for (int iteration = 0; iteration < 5; iteration++) 
        {
            for (int i = 0; i < data.length; i++) 
            {
                float x1 = data[i][0];
                float x2 = data[i][1];
                float target = data[i][2];

                float gradW1 = gradW1(x1, x2, target, w1, w2);
                float gradW2 = gradW2(x1, x2, target, w1, w2);

                w1 -= learningRate * gradW1;
                w2 -= learningRate * gradW2;
            }
            
            System.out.println("Iteration " + (iteration + 1) + ": w1 = " + w1 + ", w2 = " + w2);
        }
    }

    private static float gradW1(float x1, float x2, float y, float w1, float w2) 
    {
        return 2 * (y-(w1 * x1 + w2 * x2)) * -x1;
    }
    private static float gradW2(float x1, float x2, float y, float w1, float w2) 
    {
        return 2 * (y-(w1 * x1 + w2 * x2)) * -x2;
    }
}
