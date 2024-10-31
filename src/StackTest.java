import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack(5);  // Stack mit einer Größe von 5 initialisieren
    }

    @Test
    public void testIsEmpty() {
        System.out.println("Test: isEmpty()");
        Assert.assertTrue("Der Stack sollte leer sein.", stack.isEmpty());
        System.out.println("Der Stack ist leer: " + stack.isEmpty());
    }

    @Test
    public void testPush() {
        System.out.println("Test: push(10)");
        stack.push(10);
        System.out.println("Nach dem Push ist der Stack leer? " + stack.isEmpty());
        Assert.assertFalse("Der Stack sollte nicht leer sein.", stack.isEmpty());
        System.out.println("Die Größe des Stacks: " + stack.size());
        Assert.assertEquals("Die Größe des Stacks sollte 1 sein.", 1, stack.size());
    }

    @Test
    public void testPop() {
        System.out.println("Test: pop()");
        stack.push(10);
        int poppedValue = stack.pop();
        System.out.println("Gepoppter Wert: " + poppedValue);
        Assert.assertEquals("Der gepoppte Wert sollte 10 sein.", 10, poppedValue);
        System.out.println("Nach dem Pop ist der Stack leer: " + stack.size());
        Assert.assertEquals("Der Stack sollte leer sein.", 0, stack.size());
    }

    @Test
    public void testSize() {
        System.out.println("Test: size()");
        stack.push(10);
        stack.push(20);
        System.out.println("Stackgröße nach Push: " + stack.size());
        Assert.assertEquals("Die Größe des Stacks sollte 2 sein.", 2, stack.size());
    }

    @Test
    public void testPushExceptionForNegativeValue() {
        System.out.println("Test: push(-1)");
        try {
            stack.push(-1);  // Negativer Wert sollte eine IllegalArgumentException auslösen
            Assert.fail("Es sollte eine IllegalArgumentException geworfen werden.");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException wurde korrekt geworfen.");
        }
    }

    @Test
    public void testPushOverflow() {
        System.out.println("Test: push(overflow)");
        stack.push(10);
        try {
            stack.push(20);  // Überschreitung der Stack-Größe sollte StackOverflowError auslösen
            Assert.fail("Es sollte eine StackOverflowError geworfen werden.");
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError wurde korrekt geworfen.");
        }
    }

    @Test
    public void testPopEmptyStack() {
        System.out.println("Test: pop() auf leerem Stack");
        int result = stack.pop();
        System.out.println("Pop von leerem Stack gibt zurück: " + result);
        Assert.assertEquals("Pop von einem leeren Stack sollte -1 zurückgeben.", -1, result);
    }

    @Test
    public void testTop() {
        System.out.println("Test: top()");
        stack.push(10);
        int topValue = stack.top();
        System.out.println("Das oberste Element im Stack: " + topValue);
        Assert.assertEquals("Das oberste Element sollte 10 sein.", 10, topValue);
    }

    @Test
    public void testTopWhenEmpty() {
        System.out.println("Test: top() auf leerem Stack");
        int topValue = stack.top();
        System.out.println("Das oberste Element eines leeren Stacks: " + topValue);
        Assert.assertEquals("Das oberste Element eines leeren Stacks sollte -1 sein.", -1, topValue);
    }
}
