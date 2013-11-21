/**
 * browseFolder.js
 * ���ļ�������BrowseFolder()�������ṩһ���ļ���ѡ��Ի���
 * �Թ��û�ʵ�ֶ�ϵͳ�ļ���ѡ��Ĺ���
 * �ļ���ѡ��Ի�����ʼĿ¼��
 * Shell.BrowseForFolder(WINDOW_HANDLE, Message, OPTIONS, strPath)����
 * ��strPath��������
 * ���磺0x11--�ҵĵ���
 *   0 --����
 *  "c:\\"--ϵͳC��
 *
 * �����´���Ѹú���Ӧ�õ�һ��HTML�ļ��У�
 *  <script src="browseFolder.js"></script>
 * ����������ֱ��COPY��<script language="javascript">...</script>��ǩ�У�
 *
 * ��һ��Ĵ�����������HTML�ļ���ʹ�øú���
 * ���磺<input type="button" onclick="BrowseFolder()" />
 * ע�⣺�붨��NAMEΪsavePath���������ջ���ʾ���ص�ֵ�����磺
 *    <input type="text" name="savePath" />
 *
 * �ر�ע�����,���ڰ�ȫ���������,�㻹��Ҫ�������ò���ʹ��JS������ȷ����,
 * ���߻����"û��Ȩ��"������.
 *
 * 1�����ÿ�����վ�㣨���籾�صĿ���Ϊ��http://localhost��
 * 2����Σ�������վ�㰲ȫ�����Զ��������У����������ѡ��
 * "��û�б��Ϊ��ȫ��ActiveX�ؼ����г�ʼ���ͽű�����"----"����"
 */
function BrowseFolder() {
    alert();
    try {
        var Message = "��ѡ���ļ���";  //ѡ�����ʾ��Ϣ
        var Shell = new ActiveXObject("Shell.Application");
        var Folder = Shell.BrowseForFolder(0, Message, 0x0040, 0x11);//��ʼĿ¼Ϊ���ҵĵ���
        //var Folder = Shell.BrowseForFolder(0,Message,0); //��ʼĿ¼Ϊ������
        if (Folder != null) {
            Folder = Folder.items();  // ���� FolderItems ����
            Folder = Folder.item();  // ���� Folderitem ����
            Folder = Folder.Path;   // ����·��
            if (Folder.charAt(Folder.length - 1) != "\\") {
                Folder = Folder + "\\";
            }
            document.all.savePath.value = Folder;
            return Folder;
        }
    } catch (e) {
        alert(e.message);
    }
}   
