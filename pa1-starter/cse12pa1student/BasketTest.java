package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test
	public void addedHasCount1() { //empty basket --> add 1 item to basket
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);

		assertEquals(1, basketToTest.count());
	}


	@Test
	public void removeFromNullFalse() { //empty basket --> remove item from basket
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		

		assertEquals(false, basketToTest.removeFromBasket(i));
	}


	@Test
	public void emptyFromNullFalse() { //empty basket --> empty all items from basket
		Basket basketToTest = makeBasket();

		//Item i = new Item("Shampoo", 5);
		basketToTest.empty();

		assertEquals(0, basketToTest.count());
	}


	@Test
	public void countItem0() { //empty basket --> count number of items in basket
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);

		assertEquals(0, basketToTest.countItem(i));
	}


	@Test
	public void totalCost0() { //empty basket --> total cost of items in basket
		Basket basketToTest = makeBasket();

		//Item i = new Item("Shampoo", 5);

		assertEquals(0, basketToTest.totalCost());
	}


	@Test
	public void addedHasCountSame5() { //5 same items in basket --> check if has 5
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		assertEquals(5, basketToTest.count());
	}


	@Test
	public void countItemSameItem5() { //5 same items in basket --> check if has 5 same items
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		assertEquals(5, basketToTest.countItem(i));
	}


	@Test
	public void totalCostSameItem5() { //5 same items in basket --> check if cost is 25
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		assertEquals(25, basketToTest.totalCost());
	}


	@Test
	public void removeFromBasketSame5Check() { //5 same items in basket --> remove 1 (check if you can remove)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		assertEquals(true, basketToTest.removeFromBasket(i));
	}


	@Test
	public void removeFromBasketSame5Count() { //5 same items in basket --> remove 1 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);

		assertEquals(4, basketToTest.count());
	}


	@Test
	public void removeAllFromBasketSame5Count() { //5 same items in basket --> remove all 5 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.removeAllFromBasket(i);

		assertEquals(0, basketToTest.count());
	}






	@Test
	public void addedHasCountDifferent5() { //5 items in basket --> check if has 5
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(5, basketToTest.count());
	}


	@Test
	public void countItemDifferentItem5() { //5 items in basket --> check if has 3 i items
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(3, basketToTest.countItem(i));
	}


	@Test
	public void totalCostDifferentItem5() { //5 differnt items in basket --> check if cost is 35
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(35, basketToTest.totalCost());
	}


	@Test
	public void removeFromBasketDifferent5Check() { //5 differnt items in basket --> remove 1 (check if you can remove)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(true, basketToTest.removeFromBasket(i));
	}


	@Test
	public void removeFromBasketDifferent5Count() { //5 differnt items in basket --> remove 1 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeFromBasket(i);

		assertEquals(2, basketToTest.count());
	}


	@Test
	public void removeAllFromBasketDifferent5Count() { //5 different items in basket --> remove all 5 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeAllFromBasket(i);

		assertEquals(0, basketToTest.count());
	}







	@Test
	public void addedHasCountDifferent5SameName() { //5 items in basket, same name items --> check if has 5
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(5, basketToTest.count());
	}


	@Test
	public void countItemDifferentItem5SameName() { //5 items in basket, same name items --> check if has 3 i items
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(3, basketToTest.countItem(i));
	}


	@Test
	public void totalCostDifferentItem5SameName() { //5 differnt items in basket, same name item --> check if cost is 35
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(35, basketToTest.totalCost());
	}


	@Test
	public void removeFromBasketDifferent5CheckSameName() { //5 differnt items in basket,same name items --> remove 1 (check if you can remove)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(true, basketToTest.removeFromBasket(i));
	}


	@Test
	public void removeFromBasketDifferent5CountSameName() { //5 differnt items in basket, same name --> remove 1 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeFromBasket(i);

		assertEquals(2, basketToTest.count());
	}


	@Test
	public void removeAllFromBasketDifferent5CountSameName() { //5 different items in basket, same name --> remove all 5 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 10);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeAllFromBasket(i);

		assertEquals(0, basketToTest.count());
	}







	@Test
	public void addedHasCountDifferent5SamePrice() { //5 items in basket, same price items --> check if has 5
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(5, basketToTest.count());
	}


	@Test
	public void countItemDifferentItem5SamePrice() { //5 items in basket, same price items --> check if has 3 i items
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(3, basketToTest.countItem(i));
	}


	@Test
	public void totalCostDifferentItem5SamePrice() { //5 differnt items in basket, same price item --> check if cost is 35
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(35, basketToTest.totalCost());
	}


	@Test
	public void removeFromBasketDifferent5CheckSamePrice() { //5 differnt items in basket,same price items --> remove 1 (check if you can remove)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(true, basketToTest.removeFromBasket(i));
	}


	@Test
	public void removeFromBasketDifferent5CountSame() { //5 differnt items in basket, same price item --> remove 1 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeFromBasket(i);

		assertEquals(2, basketToTest.count());
	}


	@Test
	public void removeAllFromBasketDifferent5CountSamePrice() { //5 different items in basket, same price item --> remove all 5 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeAllFromBasket(i);

		assertEquals(0, basketToTest.count());
	}








	@Test
	public void addedHasCountDifferent5SameItem() { //5 items in basket, same items --> check if has 5
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(5, basketToTest.count());
	}


	@Test
	public void countItemDifferentItem5SameItem() { //5 items in basket, same items --> check if has 3 i items
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(3, basketToTest.countItem(i));
	}


	@Test
	public void totalCostDifferentItem5SameItem() { //5 differnt items in basket, same item --> check if cost is 35
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(35, basketToTest.totalCost());
	}


	@Test
	public void removeFromBasketDifferent5CheckSameItem() { //5 differnt items in basket,same items --> remove 1 (check if you can remove)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);

		assertEquals(true, basketToTest.removeFromBasket(i));
	}


	@Test
	public void removeFromBasketDifferent5CountSameItem() { //5 differnt items in basket, same item --> remove 1 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeFromBasket(i);

		assertEquals(2, basketToTest.count());
	}


	@Test
	public void removeAllFromBasketDifferent5CountSameItem() { //5 different items in basket, same item --> remove all 5 (check count)
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.removeAllFromBasket(i);

		assertEquals(0, basketToTest.count());
	}


	@Test 
	public void removeAllFromBasket6(){
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);

		assertFalse(basketToTest.removeAllFromBasket(i));
	}

	@Test 
	public void referenceEqualityIssueBasket5(){
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);

		assertEquals(2, basketToTest.countItem(i));
	}

	@Test
	public void addingNullDoesNotIncreaseCount1(){
		Basket basketToTest = makeBasket();
		
		basketToTest.addToBasket(t:null);
		
		assertEquals(0, basketToTest.count());
	}






}