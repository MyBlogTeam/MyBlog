package top.johnxiao.blog.core;

import top.johnxiao.blog.dao.IAdminDao;
import top.johnxiao.blog.dao.IAlbumDao;
import top.johnxiao.blog.dao.IArticleDao;
import top.johnxiao.blog.dao.IAuthsDao;
import top.johnxiao.blog.dao.IBlogDao;
import top.johnxiao.blog.dao.IClickLikeDao;
import top.johnxiao.blog.dao.ICollectDao;
import top.johnxiao.blog.dao.IDiscussDao;
import top.johnxiao.blog.dao.IFileDao;
import top.johnxiao.blog.dao.ILabelArticleDao;
import top.johnxiao.blog.dao.ILabelDao;
import top.johnxiao.blog.dao.ILinkDao;
import top.johnxiao.blog.dao.IMessageDao;
import top.johnxiao.blog.dao.INoticeDao;
import top.johnxiao.blog.dao.IPhotoDao;
import top.johnxiao.blog.dao.ITypeArticleDao;
import top.johnxiao.blog.dao.ITypeDao;
import top.johnxiao.blog.dao.IUserDao;
import top.johnxiao.blog.dao.IUserNoticeDao;
import top.johnxiao.blog.dao.impl.AdminDao;
import top.johnxiao.blog.dao.impl.AlbumDao;
import top.johnxiao.blog.dao.impl.ArticleDao;
import top.johnxiao.blog.dao.impl.AuthsDao;
import top.johnxiao.blog.dao.impl.BlogDao;
import top.johnxiao.blog.dao.impl.ClickLikeDao;
import top.johnxiao.blog.dao.impl.CollectDao;
import top.johnxiao.blog.dao.impl.DiscussDao;
import top.johnxiao.blog.dao.impl.FileDao;
import top.johnxiao.blog.dao.impl.LabelArticleDao;
import top.johnxiao.blog.dao.impl.LabelDao;
import top.johnxiao.blog.dao.impl.LinkDao;
import top.johnxiao.blog.dao.impl.MessageDao;
import top.johnxiao.blog.dao.impl.NoticeDao;
import top.johnxiao.blog.dao.impl.PhotoDao;
import top.johnxiao.blog.dao.impl.TypeArticleDao;
import top.johnxiao.blog.dao.impl.TypeDao;
import top.johnxiao.blog.dao.impl.UserDao;
import top.johnxiao.blog.dao.impl.UserNoticeDao;

public class DaoFactory {
	
	public static IAdminDao createAdminDao(){
		return new AdminDao();
	}
	
	public static IAlbumDao createAlbumDao(){
		return new AlbumDao();
	}
	
	public static IArticleDao createArticleDao(){
		return new ArticleDao();
	}
	
	public static IAuthsDao createAuthsDao(){
		return new AuthsDao();
	}
	   
	public static IBlogDao createBlogDao(){
		return new BlogDao();
	}
	
	public static IClickLikeDao createClickLikeDao(){
		return new ClickLikeDao();
	}
	
	public static ICollectDao createCollectDao(){
		return new CollectDao();
	}
	
	public static IDiscussDao createDiscussDao(){
		return new DiscussDao();
	}
	
	public static IFileDao createFileDao(){
		return new FileDao();
	}
	
	public static ILabelArticleDao createLADao(){
		return new LabelArticleDao();
	}
	
	public static ILabelDao createLabelDao(){
		return new LabelDao();
	}
	
	public static ILinkDao createLinkDao(){
		return new LinkDao();
	}
	
	public static IMessageDao createMessageDao(){
		return new MessageDao();
	}
	
	public static INoticeDao createNoticeDao(){
		return new NoticeDao();
	}
	
	public static IPhotoDao createPhotoDao(){
		return new PhotoDao();
	}
	
	public static ITypeArticleDao createTADao(){
		return new TypeArticleDao();
	}
	
	public static ITypeDao createTypeDao(){
		return new TypeDao();
	}
	
	public static IUserDao createUserDao(){
		return new UserDao();
	}
	
	public static IUserNoticeDao createUNDao(){
		return new UserNoticeDao();
	}

}
