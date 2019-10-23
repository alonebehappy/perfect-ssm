@Transactional
public abstract class BaseServiceImpl<ID extends Serializable, T extends AbstractEntity, I extends BaseDao<ID, T, I>>
	implements BaseService<ID, T, I>
{
	/** 基础DAO */
	private BaseDao<ID, T, I> baseDao;
	
	@Override
	public boolean save(T u)
	{
		if (u != null && u.getCreateDate() == null)
		{
			u.setCreateDate(new Date());
		}
		if (u != null && u.getModifyDate() == null)
		{
			u.setModifyDate(new Date());
		}
		return baseDao.save(u);
	}
	@Override
	public boolean deleteById(ID id)
	{
		return baseDao.deleteById(id);
	}
	@Override
	public boolean update(T u)
	{
		if (u != null && u.getModifyDate() != null)
		{
			u.setModifyDate(new Date());
		}
		return baseDao.update(u);
	}
	@Override
	public T getById(ID id)
	{
		return baseDao.getById(id);
	}
	@Override
	public List<T> getAll()
	{
		return baseDao.getAll();
	}
	public void setBaseDao(BaseDao<ID, T, I> baseDao)
	{
		this.baseDao = baseDao;
	}
}
