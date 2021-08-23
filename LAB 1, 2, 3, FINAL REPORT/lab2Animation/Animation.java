 


/**
 * Write a description of class Animation here.
 *
 * @author (EMMANUEL DURU)
 * @version (20.03.2020)
 */
public class Animation
{
    // instance variables - replace the example below with your own
        private Triangle triangle1;
        private Triangle triangle2;
        private Triangle triangle3;
        private Circle circle1;
        private boolean drawn;

    /**
     * Constructor for objects of class Animation
     */
    public Animation()
    {
        // initialise instance variables
                triangle1 = new Triangle();
                triangle2 = new Triangle();
                triangle3 = new Triangle();
                circle1 = new Circle();
                drawn = false;
            }
        
            /**
             * An example of a method - replace this comment with your own
             *
             * @param  y  a sample parameter for a method
             * @return    the sum of x and y
             */
            public void draw()
            {
                // put your code here
                if (!drawn)
                {
                triangle1.makeVisible();
                triangle1.changeSize(40, 30);
                triangle1.moveUp();
                triangle1.moveUp();
                triangle1.moveUp();
                triangle1.moveUp();
                triangle1.moveUp();
                triangle1.moveUp();
                triangle2.makeVisible();
                triangle2.moveUp();
                triangle2.moveUp();
                triangle2.moveUp();
                triangle2.moveUp();
                triangle2.moveUp();
                triangle2.moveDown();
                triangle1.changeSize(50, 40);
                triangle3.makeVisible();
                triangle3.moveUp();
                triangle3.changeSize(100, 80);
                triangle3.changeSize(40, 90);
                triangle3.changeSize(70, 100);
                triangle3.moveUp();
                circle1.makeVisible();
                circle1.changeColor("yellow");
                circle1.moveHorizontal(100);
                circle1.moveVertical(50);
                circle1.moveUp();
                circle1.moveUp();
                circle1.moveUp();
                circle1.moveUp();
                circle1.moveUp();
                circle1.moveUp();
                circle1.moveUp();
                circle1.moveRight();
                circle1.moveRight();
                drawn=true;

        }
        
    }
    
    public void start()
    {
        circle1.slowMoveVertical(80);
    }
}
