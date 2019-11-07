public interface BaseDao<ID extends Serializable, T extends AbstractEntity>
{
	boolean save(T u);
	
	boolean deleteById(ID id);
	
	boolean update(T u);
	
	T getById(ID id);
	
	List<T> getAll();
}
