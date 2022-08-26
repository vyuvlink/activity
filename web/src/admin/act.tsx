import "./index.scss";
import React, { useEffect, useState } from "react";
import { Button, Form, Input, message, DatePicker } from "antd";
import { queryActivity, saveActivity, uploadFile } from "../services/admin";
import moment from "moment";
import { useLocation } from "react-router";
import { parseSearchParams } from "../utils";
import Upload from "../component/upload";

const { RangePicker } = DatePicker;

const Act = () => {
  const { search } = useLocation();
  const { activity_id }: any = parseSearchParams(search);
  const [form] = Form.useForm();
  const { getFieldValue, validateFields, getFieldsValue } = form;
  const [data, setData] = useState();

  const [loading, setLoading] = useState(false);

  const cover = getFieldValue("cover");
  const id = getFieldValue("id");

  const onSubmit = () => {
    if (loading) {
      message.info("操作繁忙，请稍后再试！");
      return;
    }
    validateFields().then(() => {
      setLoading(true);
      const formData = getFieldsValue();
      const submitData = {
        ...formData,
        start_time: Math.floor(
          moment(formData.time[0]).get().toDate().getTime() / 1000
        ),
        end_time: Math.floor(
          moment(formData.time[1]).get().toDate().getTime() / 1000
        ),
      };
      saveActivity(submitData)
        .then(() => {})
        .finally(() => setLoading(false));
    });
  };

  const uploadMethod = ({ files, onSuccess, onError, onProgress }) => {
    uploadFile(files[0])
      .then((res) => {
        onSuccess();
        form.setFieldValue("cover", res.data);
        setData({ ...data });
      })
      .catch(() => onError());
  };

  const FormList = [
    {
      label: "活动名称",
      name: "name",
      rules: [{ required: true, message: "请输入活动名称" }],
      placeholder: "请输入活动名称",
    },
    {
      label: "封面图",
      name: "cover",
      rules: [{ required: true, message: "请上传封面图" }],
      placeholder: "请上传封面图",
      el: (
        <>
          <Upload image={cover} uploadMethod={uploadMethod} />
        </>
      ),
    },
    {
      label: "活动时间",
      name: "time",
      rules: [
        {
          validator: (_, value, cb) => {
            if (!value) {
              cb("请选择活动时间");
            } else if (id && !moment(data.start_time).isSame(value[0])) {
              cb("活动发布后，开始时间不允许更改");
            } else {
              cb();
            }
          },
        },
      ],
      placeholder: "请选择活动时间",
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
        />
      ),
    },
  ];

  useEffect(() => {
    // if (activity_id) {
    //   queryActivity({ activity_id }).then(({ data }) => {
    //     setData(data);
    //     form.setFieldsValue({ data });
    //   });
    // }
  }, []);

  return (
    <div className="admin-containerr">
      <Form form={form}>
        <Form.Item name="id" key={-1} className="hidden"></Form.Item>
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

export default Act;
