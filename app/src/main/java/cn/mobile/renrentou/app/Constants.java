package cn.mobile.renrentou.app;


/**
 * 常量类
 * @author secret
 *
 */
public class Constants {

	//超时时间
	public static final int HTTP_CONN_TIME_OUT = 10000;
	//默认电话
	public static final String SERVICE_TELEPHONE = "4000705286";
	public static final String COMPLAIN__TELEPHONE = "18910509988";
	public static final String RECRUITMENT_TELEPHONE = "17701271633";
	public static final String RECRUITMENT_TELEPHONE2 = "18515099058";
	
	//项目基本标记
	public static final String[] STATUS = new String[]{"全部项目","融资中","预热中","已成功","已分红"};
	public static final String[]  PROJECT_SORT=new String[]{"默认排序","最近上线","将要完成","最少出资","最高融资"};
	public static final int[] PROJECT_TYPE=new int[]{0,4,2,6,8};
	public static final String[] PROJECT_STATUS = new String[]{"未审核","待审核","预热中","项目方打款","融资中","融资失败","已成功","签订合伙协议","未通过"};
	public static final String[] MESSAGE_TYPE=new String[]{"all","private_letter","system","project"};
	public static final String[] MESSAGE_CONTENT_TYPE=new String[]{"","私信:","约谈:"};
	public static final String[] DECORARE_STYL=new String[]{"","简约","现代","中式","欧美","美式","田园","新古典","混搭","地中海","东南海","日式","北欧","其他"};
	public static final String[] FITMENT_CONTENT_TYPE=new String[]{"","餐厅/酒楼","商铺","娱乐场所","超市/商场","局部装修","其他"};
	//人人投经纬度坐标116.327539,39.896456(高德）116.334227,39.902116（百度）
	public static final String RRTLONGITUDE = "116.334227";//经度
	public static final String RRTLATITUDE = "39.902116";//纬度

//###########################本地存储key####################################################
	public static final String Login_Tag = "login_tag";

//############################################各种密匙############################################
	//key 微信
	public static final String wxappID = "wx5c58bde2781aad27";
	public static final String wxappSecret = "2c83c2673f5960082a2586576334b186";
	//key 空间
	public static final String qzoneappID = "1104303020";
	public static final String qzoneappKey = "eowNQYgQDq4W3VzZ";
	//key 新浪
	public static final String sinaappID="2483872858";
	public static final String sinaappKey="3f535c6f5e4cef4f6cb74a354eb3ddde";
	//key 腾讯微博
	public static final String tenappID="801562025";
	public static final String tenappKey="dae826f334f2843c65185f38e281f796";
//############################################接口############################################
//####basehost#####
	//线上
//	public static final String BASE_SERVER_URL2 = "http://app.renrentou.com/";
	//test
//	public static final String BASE_SERVER_URL2 = "http://app.test.renrentou.com/";
	//dev开发
	public static final String BASE_SERVER_URL2 = "http://app.dev2.renrentou.com/";
	
		
	public static String RRTHOST = BASE_SERVER_URL2;
	public static final String BASESOURCE = "?source=android";
//#################

	//获取首页项目
	public static final String GET_HOME_PROJECT_URL = "index/GetHomeProject"+BASESOURCE;
	//获取首页统计记录
	public static final String GET_HOME_COUNT_URL = "index/GetHomeCount"+BASESOURCE;
	//获取首页轮播	getAdList	获取轮播广告列表
	public static final String GET_ADLIST_URL = "adv/GetAdList"+BASESOURCE;
	public static final String GETUSERMSGLIST = "message/GetUserMsgList"+BASESOURCE;
	public static final String SETMSGSTATUS = "message/SetMsgStatus"+BASESOURCE;
	//获取征信查询wap页
	public static final String PROJECTSEARCH = "risksurvey/projectsearch"+BASESOURCE;
	//获取黑名单列表及详情
	public static final String GETBLACKLIST = "user/GetBlackList"+BASESOURCE;
	public static final String UPLOAD_IMG_URL = "user/SetUploadFile"+BASESOURCE;
	//获取项目详情	getProjectDetail	 获取项目详情
	public static final String PROJECT_DETAIL="project/getProjectDetail"+BASESOURCE;
	//项目详情资质审核状态
	public static final String GEtPROJECTCOMPANY="projectcompany/GetProjectCompany"+BASESOURCE;
	//项目详情预算与退出机制
	public static final String  GETPROJECTBUDGET = "project/GetProjectBudget"+BASESOURCE;
	//项目详情已有店铺概况
	public static final String  GETSTOREDETAIL = "project/GetStoreDetail"+BASESOURCE;
	//提交手机信息
	//public static final String COMMT_DEVICES_INFO_URL = "setMobileDevicesRecord"+BASESOURCE;
	//用户登录（获取token）	setLogin	登录获取token授权
	public static final String LOGIN_URL = "login/SetLogin"+BASESOURCE;
	//退出登录
	public static final String LOGOUT_URL = "login/setLoginOut"+BASESOURCE;
	//用户注册	setRegister	用户注册
	public static final String REGISTER_URL = "register/setRegister"+BASESOURCE;
	//注册手机验证码	getMobileCode	获取注册手机验证码
	public static final String VERIFICATION_CODE_URL = "register/getMobileCode"+BASESOURCE;
	//修改手机号码验证码
	public static final String PHONEVERIFICATION_CODE_URL = "account/GetLoanMobileCode"+BASESOURCE;
	//获取邮箱验证码
	public static final String EMAILVERIFICATION_CODE_URL = "user/GetEmailCode"+BASESOURCE;
	//获取用户详情	getUserInfo	 用户信息获取
	public static final String ALTER_USER_INFO = "user/GetUserInfo"+BASESOURCE;

	//获取城市列表	getCityList	获取开通城市列表（首页定位）
	public static final String CITY_LIST="area/GetCityList"+BASESOURCE;
	//获取项目列表	getProjectList	获取项目列表(主页，找项目)
	public static final String GET_PROJECT_LIST_URL = "project/getProjectList"+BASESOURCE;
	//获取股权项目	getStockList	获取股权项目
	public static final String GET_STOCK_LIST = "stock/GetStockList"+BASESOURCE;
	//获取融资互动列表	getProjectCommentList	 获取融资互动列表
	public static final String GET_PROJECT_COMMENTLIST_URL = "project/GetProjectCommentList"+BASESOURCE;
	//融资互动评论	setProjectComment	添加融资互动评论
	public static final String SET_PROJECT_COMMENT_URL = "project/SetProjectComment"+BASESOURCE;
	//关注项目	setProjectConcern	设置项目关注状态（取消关注）
	public static final String SET_PROJECT_CONCERN_URL = "project/setProjectConcern"+BASESOURCE;
	//约谈项目	setProjectSpeak	发送约谈请求
	public static final String SET_PROJECT_SPEAK_URL = "project/setProjectSpeak"+BASESOURCE;
	//预约认购	
	public static final String SET_PROJECT_BUY_REWARD_URL = "project/SetAppointmentToBuy"+BASESOURCE;
	//股权认购	setProjectBuyStock	认购提交（股权模式）
	public static final String SET_PROJECT_BUY_STOCK_URL = "project/SetProjectBuyStock"+BASESOURCE;
	//安全保障  security 安全保障
	public static final String SECURITY = "special/security"+BASESOURCE;
	//群组列表	getGroupList 	群组列表
	public static final String GET_GROUP_LIST = "chat/GetGroupList"+BASESOURCE;
	//获取群组详情 	updateGroupInfo 	获取群组详情 
	public static final String GET_GROUP_INFO = "chat/GetGroupInfo"+BASESOURCE;
	//修改群组信息	getGroupList 	修改群组信息
	public static final String UPDATE_GROUP_INFO = "chat/UpdateGroupInfo"+BASESOURCE;
	//群主移除群组用户	deleteGroupUser 	群主移除群组用户
	public static final String DELETTE_GROUP_USER = "chat/DeleteGroupUser"+BASESOURCE;
	//将群组用户加入黑名单	addBlocksUser 	将群组用户加入黑名单
	public static final String ADD_BLOCKS_USER = "chat/AddBlocksUser"+BASESOURCE;
	//退出群组【new】	exitGroup 	退出群组【new】
	public static final String EXITGROUP = "chat/ExitGroup"+BASESOURCE;
	//获取聊天组搜索条件  getSearchList     获取聊天组搜索条件
	public static final String GET_SEARCH_LIST = "chat/GetSearchList"+BASESOURCE;
	//选址搜索条件  getSearchAddressCon     选址搜索条件
	public static final String GET_SEARCH_ADDRESS_CON = "projectstore/GetSearchAddressCon"+BASESOURCE;
	//获取项目选址列表  getSiteSelectionList     获取项目选址列表
	public static final String GET_SITE_SELECTION_LIST = "projectstore/GetSiteSelectionList"+BASESOURCE;
	//装修搜索条件  getSearchDecorateCon     装修搜索条件
	public static final String GET_SEARCH_DECORATE_CON = "projectstore/GetSearchDecorateCon"+BASESOURCE;
	//获取项目装修列表   getDecorateList     获取项目装修列表
	public static final String GET_DECORATE_LIST = "projectStore/GetDecorateList"+BASESOURCE;
	//账户充值	accountsPrepaidPhone	账户充值
	public static final String ACCOUNTS_PREPAID_PHONE_URL = "account/AccountsPrepaidPhone"+BASESOURCE;
	//账户提现   accountAccountExtracting  账户提现
	public static final String ACCOUNTS_ACCOUNT_EXTRACTING_URL = "account/AccountExtracting"+BASESOURCE;
	//绑定银行卡   accountBindBankCard   绑定银行卡
	public static final String ACCOUNTS_BINDBANK_CARD_URL = "account/BindBankCard"+BASESOURCE;
	//绑定银行卡   accountBindBankCard   绑定银行卡后获得信息
	public static final String ACCOUNTS_BINDBANK_CARD_INFO = "account/GetBankCardInfo"+BASESOURCE;
	//绑定银行卡后获得信息   accountUnbindBankCard   解绑银行卡
	public static final String ACCOUNTS_UNBIND_BANKCARD_URL = "account/UnbindBankCard"+BASESOURCE;
	//会员账户信息	getUserAccountBalance	会员账户信息
	public static final String GET_USER_ACCOUNT_BALANCE_URL = "account/GetUserAccountBalance"+BASESOURCE;
	//交易记录列表	getTradingRecordList	交易记录列表
	public static final String GET_TRADING_RECORD_LIST_URL = "account/GetTradingRecordList"+BASESOURCE;
	//修改用户资料	setUserInfo	 提交用户信息资料修改
	public static final String SET_USER_INFO_URL = "user/SetUserInfo"+BASESOURCE;
	//修改用户密码	setUserPassword	 用户证号密码修改
	public static final String SET_USER_PASSWORD_URL = "user/SetUserPassword"+BASESOURCE;
	//找回用户密码	setFindPassword	 用户证号密码找回
	public static final String SET_FIND_PASSWORD_URL = "user/SetFindPassword"+BASESOURCE;
	//获取用户详情	getUserInfo	 用户信息获取
	public static final String GET_USER_INFO_URL = "user/GetUserInfo"+BASESOURCE;
	//意见反馈	setFeedback	提交用户意见反馈
	public static final String SET_FEED_BACK_URL = "feedback/SetFeedback"+BASESOURCE;
	//电子协议下载
	public static final String GET_RISK_WARNING="project/GetRiskWarning"+BASESOURCE;
	//修改认购人联系方式	setProjectBuyNews	修改认购人联系方式
	public static final String SET_PROJECT_BUY_NEWS_URL = "user/setProjectBuyNews"+BASESOURCE;
	//获取认购人联系方式		
	public static final String GET_PROJECT_BUY_NEWS_URL = "user/getProjectBuyNews"+BASESOURCE;
	//获取项目一级分类	getObjectOne	获取项目一级分类
	public static final String GETSEARCHPROJECTTYPE = "project/GetSearchProjectType"+BASESOURCE;
	//获取股权项目搜索条件	GetSearchStockTrade	获取股权项目搜索条件
	public static final String GET_SEARCH_STOPCK_TRADE = "stock/GetSearchStockTrade"+BASESOURCE;
	//申请投资人认证
	public static final String APPLY_INVESTOR_CERTIFICATION = "projectcompany/ApplyInvestCertification"+BASESOURCE;
	//项目搜索热词
	public static final String GET_PROJECT_SEARCHWORDS = "project/GetProjectSearchWords"+BASESOURCE;
	//获取项目财务管理信息
	public static final String GETFINANCEINFO = "financial/GetFinanceInfo"+BASESOURCE;
	//获取营业店铺列表	getEntityProjectList	获取营业店铺列表
	public static final String GETENTITYPROJECTLIST = "project/GetEntityProjectList"+BASESOURCE;
	//获取股东名单
	public static final String GET_STOCKHOLDER_LIST="project/GetShareholderTeam"+BASESOURCE;
	//我发布的项目申请用款
	public static final String SET_APPLY_FOR_MONEY = "project/FundsApply"+BASESOURCE;
	//我发布的项目申请用款记录
	public static final String GET_APPLY_FOR_LIST= "project/GetMoneyApplyList"+BASESOURCE;
	//我发布的项目上传票据信息
	public static final String SET_PERSONAL_UPLOAD_BILL= "financial/SetBillInfo"+BASESOURCE;
	//我发布的项目
	public static final String GET_EXPENDITURE_LIST= "project/GetFinanceExpenditureList"+BASESOURCE;
	//修改地址获取城市列表
	public static final String GET_CITY_LIST= "area/GetCityList"+BASESOURCE;
	//加入群组聊天
	public static final String ADD_GROUP_USER = "chat/AddGroupUsers"+BASESOURCE;
	//对项目评论的回复
	public static final String REPLY_PROJECT_COMMENT = "project/ReplyProjectComment"+BASESOURCE;
	//获取股权交易详情
	public static final String GET_PROJECT_STOCKLIST="stock/GetProjectStockList"+BASESOURCE; 
	//我投资的项目出售股权
	public static final String DoSaleAdd = "stock/DoSaleAdd"+BASESOURCE;
	//项目详情获取项目历程
	public static final String Get_PROJECT_PROGRESS = "project/GetProjectProgress"+BASESOURCE;
	//获取项目资金支出类型
	public static final String GET_EXPENDITURE_TYPE ="financial/GetExpenditureType"+BASESOURCE;
	//认证明星领投人及机构领投
	public static final String SET_USER_AUTHENTICATION="user/SetUserAuthentication"+BASESOURCE; 
	//获取领投人信息
	public static final String GET_USER_AUTHENTICATION="/user/GetUserAuthentication"+BASESOURCE; 
	//获取投资排行
	public static final String GET_TOTAL_SENIORITYORDER = "projectinvestment/GetTotalSeniorityOrder"+BASESOURCE;
	//获取分红详情 
	public static final String GET_PROJECTSHARESUBJECTS = "project/GetProjectShareSubjects"+BASESOURCE;
	//监控
	public static final String GETPROJECTMONITORLIST= "project/getProjectMonitorList"+BASESOURCE;
	//获取我的投资项目	GetInvestProjects
	public static final String GET_INVEST_PROJECTS = "project/GetInvestProjects"+BASESOURCE;
	//获取我的关注项目 GetFollowProjects
	public static final String GET_FOLLOW_PROJECTS = "project/GetFollowProjects"+BASESOURCE;
	//获取我的发布项目 GetPublishProjects
	public static final String GET_PUBLISH_PROJECTS = "project/GetPublishProjects"+BASESOURCE;
	//获取相关项目 GetRelevantProjects
	public static final String GET_RELEVANT_PROJECTS = "project/GetRelevantProjects"+BASESOURCE;
	//获取我购买的额股份
	public static final String GET_SHARE_BUY = "stock/GetPurchaseShares"+BASESOURCE;
	//获取我卖出的股份
	public static final String GET_SHARE_SAIL = "stock/GetSaleShares"+BASESOURCE;
	//撤销我卖的股份
	public static final String GET_SHARE_CANEL = "stock/SetEquityCancel"+BASESOURCE;
	//确认股份交易完成
	public static final String GET_SHARE_FINISH = "stock/FinishConfirm"+BASESOURCE;
	//获取电话变量
	public static final String GET_VARIABLE = "about/GetPhoneCompany"+BASESOURCE;
	//应用变量缓存
	public static final String ACACHE_VARIABLE = "acache_variable"+BASESOURCE;
	//获取web变量
	public static final String GET_WEBVARIABLE = "special/GetSpecialUrl"+BASESOURCE;
	//明星投资人列表
	public static final String GET_STAR_USER = "star/GetInvestor"+BASESOURCE;
	//明星投资人详情
	public static final String GET_STAR_USER_DETAIL = "star/GetInvestorDetail"+BASESOURCE;
	//明星项目列表
	public static final String GET_STAR_PRO = "star/GetProject"+BASESOURCE;
	//明星项目详情
	public static final String GET_STAR_PRO_DETAIL = "star/GetProjectDetail"+BASESOURCE;
	//获取积分商品列表
	public static final String GET_GIFT_LIST = "shop/GetGiftList"+BASESOURCE;
	//积分获取方式
	public static final String GET_SHOP_RULE = "shop/Rule"+BASESOURCE;
	//提交商品表单
	public static final String POST_GIFT_ORDERS = "shop/SetGiftOrders"+BASESOURCE;
	//新手专区
	public static final String NEW_BIE_GUIDE = "help/newbieguide"+BASESOURCE;
	//我的积分兑换订单
	public static final String GET_GIFT_ORDERS = "shop/GetGiftOrders"+BASESOURCE;
//##################################参数############################################	
    //敏感词
    public static final String KWORD = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +
            "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +
            "table|from|grant|use|group_concat|column_name|" +
            "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +
            "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";//过滤掉的sql关键字，可以手动添加

}
