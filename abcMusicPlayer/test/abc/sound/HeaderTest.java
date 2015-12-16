package abc.sound;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderTest {
    
    //Check default initialization
    //     Check with keys other than C
    //Check default length initialization based on meter
    //Check length change after meter initialization (meter > 0.75, meter < 0.75)
    //Check setTempo with different default length
    //Check parse with minimum arguments
    //Check parse with arguments in various orders
    
    //Test for default settings for Header
    @Test
    public void testDefaultHeader(){
        Header h = new Header(1, "", "C");
        assertEquals(4, h.getMeterNum());
        assertEquals(4, h.getMeterDenum());
        assertEquals(8, h.getLengthDenum());
        assertEquals(1, h.getLengthNum());
        assertEquals(100, h.getTempo());
        int num = h.getLengthNum();
        assertEquals(num, h.getTempoNum());
        int denom = h.getLengthDenum();
        assertEquals(denom, h.getTempoDenom());
    }
    
    //Test length with  meter < 0/75
    @Test
    public void testChangedMeter(){
        Header h = new Header(1, "", "C");
        h.setMeter(2, 4);
        assertEquals(16, h.getLengthDenum());
        assertEquals(1, h.getLengthNum());
    }
    
    //Test header with minimum requirements f, checks key
    @Test
    public void testParseMinRequirements(){
        Header h = Header.parse("X:1\r\nT:I LOVE PIE\nK:Cm\n");
        assertEquals(1, h.getIndex());
        assertEquals("ILOVEPIE", h.getTitle());
        assertEquals("Cm", h.getKey());
        assertEquals("{A=-1, B=-1, C=0, D=0, E=-1, F=0, G=0}", h.getAccidentals().toString());
    }
    
    //Test Meter with C
    @Test
    public void testParseComposerMeterFields(){
        Header h = Header.parse("X:1\r\n T:I LOVE PIE\n C:fsf\n M:C\n K:Cm\n");
        assertEquals(1, h.getIndex());
        assertEquals("ILOVEPIE", h.getTitle());
        assertEquals("fsf", h.getComposer());
        assertEquals("Cm", h.getKey());
        assertEquals(4, h.getMeterNum());
        assertEquals(4, h.getMeterDenum());
        assertEquals(8, h.getLengthDenum());
        assertEquals(1, h.getLengthNum());
        
        assertEquals("{A=-1, B=-1, C=0, D=0, E=-1, F=0, G=0}", h.getAccidentals().toString());
    }
    
    //Test Meter with C|
    @Test
    public void testTwoTwoMeterFields(){
        Header h = Header.parse("X:1\r\n T:I LOVE PIE\n C:fsf\n M:C|\n K:Cm\n");
        assertEquals(1, h.getIndex());
        assertEquals("ILOVEPIE", h.getTitle());
        assertEquals("fsf", h.getComposer());
        assertEquals("Cm", h.getKey());
        assertEquals(2, h.getMeterNum());
        assertEquals(2, h.getMeterDenum());
        assertEquals(8, h.getLengthDenum());
        assertEquals(1, h.getLengthNum());
        
        assertEquals("{A=-1, B=-1, C=0, D=0, E=-1, F=0, G=0}", h.getAccidentals().toString());
    }
    
    //Test header with different meter and setting tempo to be different from length
    @Test
    public void testParseDiffMeterTempoFields(){
        Header h = Header.parse("X: 1\nT:Bagatelle No.25 in A, WoO.59\nC:Ludwig van Beethoven\nV:1\nV:2\nM:3/8\nL:1/16\nQ:1/8=140\nK:Am\n");
        assertEquals(1, h.getIndex());
        assertEquals(3, h.getMeterNum());
        assertEquals(8, h.getMeterDenum());
        assertEquals(16, h.getLengthDenum());
        assertEquals(1, h.getLengthNum());
        assertEquals(1, h.getTempoNum());
        assertEquals(8, h.getTempoDenom());
        assertEquals(140, h.getTempo());
    }
    
    //Test Header must start with X, T, and end with K
    @Test(expected=IllegalArgumentException.class)
    public void testParseFieldsOutofOrder(){
        Header h = Header.parse("C:fsf\n M:C|\n K:Cm\nX:1\r\n T:I LOVE PIE\n");
        assertEquals(1, h.getIndex());
        assertEquals("ILOVEPIE", h.getTitle());
        assertEquals("fsf", h.getComposer());
        assertEquals("Cm", h.getKey());
        assertEquals(2, h.getMeterNum());
        assertEquals(2, h.getMeterDenum());
        assertEquals(8, h.getLengthDenum());
        assertEquals(1, h.getLengthNum());

        assertEquals("{A=-1, B=-1, C=0, D=0, E=-1, F=0, G=0}", h.getAccidentals().toString());
    }
    
}
