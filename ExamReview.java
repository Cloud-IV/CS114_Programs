//**********************************************************************************************************************
//  ExamReview.java
//
//  Review for final exam.
//**********************************************************************************************************************

public class ExamReview
{
    public static void main(String[] args)
    {
        int m = 5;
        for (boolean done = false; !done; m--);
        {
            if (m < 3)
            {
                done = true;
            }
        }
        System.out.println(m);
    }
}
