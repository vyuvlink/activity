import React, { useEffect, useState } from "react";
import { Button, Form, Input, message, Upload, DatePicker } from "antd";
import { LoadingOutlined, PlusOutlined } from "@ant-design/icons";
import { saveActivity, uploadFile } from "../services/admin";
import moment from "moment";
import { UploadChangeParam, UploadFile } from "antd/lib/upload";

const { RangePicker } = DatePicker;

const cover_image =
  "https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png";

const App = () => {
  const [form] = Form.useForm();
  const [loading, setLoading] = useState(false);
  const [uploading, setUploading] = useState(false);
  const cover = form.getFieldValue("cover");

  const onSubmit = () => {
    if (loading) {
      message.info("操作繁忙，请稍后再试！");
      return;
    }
    form.validateFields().then(() => {
      setLoading(true);
      saveActivity(form.getFieldsValue())
        .then(() => {})
        .finally(() => setLoading(false));
    });
  };

  console.log(form.getFieldsValue());

  const onUpload = (info: UploadChangeParam<UploadFile>) => {
    uploadFile(info.file.originFileObj).then((res) => {
      form.setFieldsValue({ cover: res.data });
    });
    if (info.file.status === "uploading") {
      setUploading(true);
      return;
    }
  };

  const onDateChange = () => {};

  const FormList = [
    {
      label: "活动名称",
      name: "name",
      rules: [{ required: true, message: "请输入活动名称" }],
      placeholder: "请输入活动名称",
    },
    {
      label: "请上传封面",
      name: "cover",
      rules: [{ required: true, message: "请上传封面" }],
      placeholder: "请上传封面",
      el: (
        <Upload
          listType="picture-card"
          showUploadList={false}
          onChange={onUpload}
          customRequest={() => {}}
        >
          {cover ? (
            <img src={cover} alt="avatar" style={{ width: "100%" }} />
          ) : (
            <div>
              {uploading ? <LoadingOutlined /> : <PlusOutlined />}
              <div style={{ marginTop: 8 }}>Upload</div>
            </div>
          )}
        </Upload>
      ),
    },
    {
      label: "活动名称",
      name: "time",
      rules: [{ required: true, message: "请输入活动名称" }],
      placeholder: "请输入活动名称",
      el: (
        <RangePicker
          format="YYYY-MM-DD HH:mm:ss"
          showTime={{
            hideDisabledOptions: true,
            defaultValue: [
              moment("00:00:00", "HH:mm:ss"),
              moment("23:59:59", "HH:mm:ss"),
            ],
          }}
          onChange={onDateChange}
        />
      ),
    },
  ];

  useEffect(() => {}, []);

  return (
    <div className="admin-containerr">
      <Form form={form}>
        {FormList.map(
          ({ label, name, placeholder, rules, el = null }, index) => {
            const RenderEl = el || <Input placeholder={placeholder} />;

            return (
              <Form.Item label={label} name={name} rules={rules} key={index}>
                {RenderEl}
              </Form.Item>
            );
          }
        )}
      </Form>
      <Button
        className="btn mt10"
        loading={loading}
        type="primary"
        htmlType="submit"
        onClick={onSubmit}
      >
        提交
      </Button>
    </div>
  );
};

export default App;
