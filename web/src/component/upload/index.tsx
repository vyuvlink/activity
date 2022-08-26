import "./index.scss";
import React, { useState } from "react";
import { LoadingOutlined, PlusOutlined } from "@ant-design/icons";
import { message, Modal } from "antd";

const Upload = (props) => {
  const { uploadMethod, image, accept, multiple } = props;
  const [loading, setloading] = useState(false);
  const [previewVisible, setPreviewVisible] = useState(false);

  const handleCancel = () => setPreviewVisible(false);

  const onSuccess = () => {
    setloading(false);
  };

  const onError = () => {
    setloading(false);
  };

  const onProgress = () => {};

  const onChange = (e) => {
    if (loading) {
      return message.info("正在上传中...");
    }
    if (!e.target.files.length) {
      return;
    }
    setloading(true);
    uploadMethod({ files: e.target.files, onSuccess, onError, onProgress });
  };

  return (
    <div className="upload-container" onClick={onChange}>
      {!loading && !image && (
        <input
          multiple={multiple}
          accept={accept}
          className="upload-file"
          type="file"
          onChange={onChange}
        />
      )}
      {image ? (
        <div onClick={() => setPreviewVisible(true)}>
          <img src={image} alt="avatar" style={{ width: "100%" }} />
        </div>
      ) : (
        <div>
          {loading ? <LoadingOutlined /> : <PlusOutlined />}
          <div style={{ marginTop: 8 }}>Upload</div>
        </div>
      )}
      <Modal
        visible={previewVisible}
        title="图片预览"
        footer={null}
        onOk={() => {}}
        onCancel={handleCancel}
      >
        <img alt="pic" style={{ width: "100%" }} src={image} />
      </Modal>
    </div>
  );
};

export default Upload;
