import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author Nina
 * DateTime 2020/8/2 10:17
 * Description 处理Blob(Binary Long Object)类型的数据（上传和下载）
 */
public class BlobTest {
    JFrame jf = new JFrame("图片管理程序");
    private static Connection conn;
    private static PreparedStatement insert;
    private static PreparedStatement query;
    private static PreparedStatement queryAll;
    //定义一个DefaultListModel对象
    private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();
    private JList<ImageHolder> imageList = new JList<>(imageModel);
    private JTextField filePath = new JTextField(26);
    private JButton browserBn = new JButton("...");
    private JButton uploadBn = new JButton("上传");
    private JLabel imageLabel = new JLabel();
    //以当前路径创建文件选择器
    JFileChooser chooser = new JFileChooser(".");
    //创建文件过滤器
    ExtensionFileFilter filter = new ExtensionFileFilter();

    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(".\\src\\mysql.ini"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String pass = props.getProperty("pass");
            //获取数据库连接
            conn = DriverManager.getConnection(url, user, pass);
            //创建执行插入操作的PreparedStatement对象
            //该对象执行插入后可以返回自动生成的主键
            insert = conn.prepareStatement("insert into img_table values(null,?,?)", Statement.RETURN_GENERATED_KEYS);
            //创建2个PreparedStatement对象，用于查询指定的图片和全部图片
            query = conn.prepareStatement("select img_data from img_table where img_id=?");
            queryAll = conn.prepareStatement("select img_id,img_name from img_table");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        new BlobTest().init();
    }

    public void init() throws SQLException {
        //初始化文件选择器
        filter.addExtensions("jpg");
        filter.addExtensions("jpeg");
        filter.addExtensions("gif");
        filter.addExtensions("png");
        filter.setDescription("图片文件(*.jpg,*.jpeg,*.gif,*,png)");
        chooser.addChoosableFileFilter(filter);
        //禁止文件类型下拉列表中的所有文件选项
        chooser.setAcceptAllFileFilterUsed(false);
        //初始化程序界面
        fillListModel();
        filePath.setEditable(false);
        //只能单选
        imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel jp = new JPanel();
        jp.add(filePath);
        jp.add(browserBn);
        browserBn.addActionListener(event -> {
            //显示文件对话框
            int result = chooser.showDialog(jf, "浏览图片上传");
            //如果用户同意，即打开
            if (result == JFileChooser.APPROVE_OPTION) {
                filePath.setText(chooser.getSelectedFile().getPath());
            }
        });
        jp.add(uploadBn);
        uploadBn.addActionListener(avt -> {
            //如果上传的文本框有内容
            if (filePath.getText().trim().length() > 0) {
                //将指定文件保存至数据库
                upload(filePath.getText());
                //清空文本框内容
                filePath.setText("");
            }
        });
        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        left.add(jp, BorderLayout.SOUTH);
        jf.add(left);
        imageList.setFixedCellWidth(160);
        jf.add(new JScrollPane(imageList), BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //如果鼠标双击
                if (e.getClickCount() >= 2) {
                    //取出其中的list项
                    ImageHolder cur = imageList.getSelectedValue();
                    try {
                        showImage(cur.getId());
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                }
            }
        });
        jf.setSize(620, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    //=========查找img_table填充ListModel==========
    public void fillListModel() throws SQLException {
        try (
                ResultSet rs = queryAll.executeQuery()) {
            //先清除所有元素
            imageModel.clear();
            //把查询的记录添加到ListModel
            while (rs.next()) {
                imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
            }
        }
    }

    //===========将指定图片放入数据库=============
    public void upload(String fileName) {
        //截取文件名
        String imageName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.indexOf('.'));
        File f = new File(fileName);
        try (InputStream is = new FileInputStream(f)) {
            //设置图片名参数
            insert.setString(1, imageName);
            //设置二进制流参数
            insert.setBinaryStream(2, is, (int) f.length());
            int affect = insert.executeUpdate();
            //插入成功，则更新ListModel
            if (affect == 1) {
                fillListModel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据图片ID来显示图片
    public void showImage(int id) throws SQLException {
        //设置参数
        query.setInt(1, id);
        try (ResultSet rs = query.executeQuery()) {
            if (rs.next()) {
                //取出Blob列
                Blob imgBlob = rs.getBlob(1);
                //取出Blob中的数据
                ImageIcon icon = new ImageIcon(imgBlob.getBytes(1L, (int) imgBlob.length()));
                imageLabel.setIcon(icon);
            }
        }
    }
}

class ExtensionFileFilter extends FileFilter {
    private String description = "";
    private ArrayList<String> extensions = new ArrayList<>();

    //添加文件扩展名
    public void addExtensions(String extension) {
        if (!extension.startsWith(".")) {
            extension = "." + extension;
            extensions.add(extension.toLowerCase());
        }
    }

    //设置文件过滤器的描述文本
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    /**
     * description: 判断文件过滤器是否会接受该文件
     *
     * @param f
     * @return boolean
     */
    public boolean accept(File f) {
        //如果该文件是路径，接受该文件
        if (f.isDirectory()) return true;
        //将文件名转为小写（忽略大小写）
        String name = f.getName().toLowerCase();
        //遍历所有可接受的扩展名，如果扩展名相同，该文件可接受
        for (String extension : extensions) {
            if (name.endsWith(extension))
                return true;
        }
        return false;
    }

    @Override
    /**
     * description: 返回过滤器的描述文本
     *
     * @param
     * @return java.lang.String
     */
    public String getDescription() {
        return description;
    }
}

class ImageHolder {
    //封装图片id
    private int id;
    //图片名字
    private String name;

    public ImageHolder() {
    }

    public ImageHolder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}