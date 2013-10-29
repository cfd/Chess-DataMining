package analysis;

public abstract class AbstractMutableOrderedItemset extends AbstractOrderedItemset{

	/** Constructor**/
	public AbstractMutableOrderedItemset() {
		super();
	}
	
	/**
	 * Add an item to this itemset
	 * @param value the item
	 */
	public abstract void addItem(Integer value);
	
	/**
	 * This method create a new empty itemset and return it
	 * @return an empty itemset
	 */
	protected abstract AbstractMutableOrderedItemset createNewEmptyItemset();


	/**
	 * Make a copy of this itemset except that any item of a given itemset
	 * are not included in the copy.
	 * @param itemsetToNotKeep  the items that should not be included
	 * @return the copy
	 */
	public AbstractMutableOrderedItemset cloneItemSetMinusAnItemset(AbstractMutableOrderedItemset itemsetToNotKeep){
		// create a new itemset
		AbstractMutableOrderedItemset itemset = createNewEmptyItemset();
		// Make a loop to copy each item 
		for(int i=0; i< size(); i++){
			String item = this.get(i);
			// If the current item  should  be included, we add it.
			if(!itemsetToNotKeep.contains(item)){
				itemset.addItem(item);
			}
		}
		return itemset; // return the new itemset
	}
	
	private void addItem(String item) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Make a copy of this itemset but exclude a given item from the copy.
	 * @param itemToNotInclude  the item that should not be included
	 * @return the copy
	 */
	public AbstractMutableOrderedItemset cloneItemSetMinusOneItem(Integer itemToNotInclude){
		// create a new itemset
		AbstractMutableOrderedItemset itemset = createNewEmptyItemset();
		// Make a loop to copy each item 
		for(int i=0; i< size(); i++){
			String item = this.get(i);
			// If the current item  should  be included, we add it.
			if(!itemToNotInclude.equals(item)){
				itemset.addItem(item);
			}
		}
		return itemset; // return the new itemset
	}
	

	/**
	 * This method return an itemset containing items that are included
	 * in this itemset and in a given itemset
	 * @param itemset2 the given itemset
	 * @return the new itemset
	 */
	public AbstractMutableOrderedItemset intersection(AbstractMutableOrderedItemset itemset2) {
		AbstractMutableOrderedItemset intersection = createNewEmptyItemset();
		for(int i=0; i< size(); i++){
			String item = this.get(i);
			
			if (itemset2.contains(item)) {
				intersection.addItem(item);
			}
		}
		return intersection;
	}

}