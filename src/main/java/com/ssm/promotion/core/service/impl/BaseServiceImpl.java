public class BaseServiceImpl<ID extends Serializable, T extends AbstractEntity<ID>> implements BaseService<ID, T> {

	@Autowired
	private BaseDao<ID, T> baseMapper;

	@Override
	@Transactional
	public int deleteByPrimaryKey(ID id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int insert(T record) {
		return baseMapper.insert(record);
	}

	@Override
	@Transactional
	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(ID id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional
	public int updateByPrimaryKey(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<T> selectList(T record) {
		return baseMapper.selectList(record);
	}

	@Override
	public PageInfo<T> getPageData(T record, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = baseMapper.selectList(record);
		PageInfo<T> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

}
