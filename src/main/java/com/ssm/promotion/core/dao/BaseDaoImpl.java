@SuppressWarnings("all")
public abstract class BaseDaoImpl<ID extends Serializable, T extends AbstractEntity, I extends BaseDao<ID, T, I>> 
	implements BaseDao<ID, T, I>
{
	@Resource(name = "sqlSessionFactory")
	protected SqlSessionFactory sqlSessionFactory;

	/** 当前接口类型 */
	private Class<I> curDao;
	
	public BaseDaoImpl()
	{
	    ParameterizedType pt = (ParameterizedType)getClass().getGenericSuperclass();	   
	    this.curDao = ((Class)pt.getActualTypeArguments()[2]);
	}
	@Override
	public boolean save(T u)
	{
		return getMapper().save(u);
	}
	@Override
	public boolean deleteById(ID id)
	{
		return getMapper().deleteById(id);
	}
	@Override
	public boolean update(T u)
	{
		return getMapper().update(u);
	}
	@Override
	public T getById(ID id)
	{
		return getMapper().getById(id);
	}
	@Override
	public List<T> getAll()
	{
		return getMapper().getAll();
	}
	protected SqlSession getSession()
	{
		return sqlSessionFactory.openSession();
	}
	protected I getMapper()
	{
		return getSession().getMapper(curDao);
	}
}
