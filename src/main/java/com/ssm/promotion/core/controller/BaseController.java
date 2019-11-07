public class BaseController<ID extends Serializable, T extends AbstractEntity<ID>, S extends BaseService<ID, T>> {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	protected S service = null;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Result insert(@RequestBody T model, HttpServletRequest request) {
		Result result = new Result(true);

		try {
			String createBy = request.getHeader("account");
			model.setCreateBy(createBy);
			model.setCreateTime(new Date());
			service.insertSelective(model);
			result.setObj(model);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			logger.error("insert error", e);
		}

		return result;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result update(@RequestBody T model, HttpServletRequest request) {

		Result result = new Result(true);

		try {
			String updateBy = request.getHeader("account");
			model.setUpdateBy(updateBy);
			model.setUpdateTime(new Date());
			service.updateByPrimaryKeySelective(model);
			result.setObj(model);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			logger.error("update error", e);
		}

		return result;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Result get(@PathVariable("id") ID id) {

		Result result = new Result(true);

		try {
			T model = service.selectByPrimaryKey(id);
			result.setObj(model);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			logger.error("get error", e);
		}

		return result;
	}

	@RequestMapping(value = "/getPage/{pageNum}/{pageSize}", method = RequestMethod.POST)
	public Result getPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
			@RequestBody T record) {

		Result result = new Result(true);

		try {
			PageInfo<T> pageInfo = service.getPageData(record, pageNum, pageSize);
			result.setObj(pageInfo);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			logger.error("getPage error", e);
		}

		return result;
	}

}
