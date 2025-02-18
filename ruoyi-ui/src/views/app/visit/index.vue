<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="header">
      <h1>访问登记</h1>
      <p>请填写以下信息完成登记</p>
    </div>

    <!-- 表单区域 -->
    <div class="form-container">
      <el-form :model="form" ref="form" :rules="rules" label-width="100px" size="medium" class="visit-form">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="手机号" prop="phoneNumber">
          <el-input v-model="form.phoneNumber" placeholder="请输入手机号" type="tel" />
        </el-form-item>
        <el-form-item label="工作单位" prop="workplace">
          <el-input v-model="form.workplace" placeholder="请输入工作单位" />
        </el-form-item>
        <el-form-item label="证件号码" prop="idNumber">
          <el-input v-model="form.idNumber" placeholder="请输入证件号码" />
        </el-form-item>
        <el-form-item label="车牌号" prop="licensePlate">
          <el-input v-model="form.licensePlate" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="停车时间" prop="parkingTime">
          <el-input v-model="form.parkingTime" placeholder="请输入停车时间" />
        </el-form-item>
        <el-form-item label="访问部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入访问部门" />
        </el-form-item>
        <el-form-item label="被访人" prop="interviewee">
          <el-input v-model="form.interviewee" placeholder="请输入被访人" />
        </el-form-item>
        <el-form-item label="访问事由" prop="reason">
          <el-input v-model="form.reason" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="访问日期" prop="visitDate">
          <el-date-picker
            v-model="form.visitDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择访问日期"
            clearable
          />
        </el-form-item>
      </el-form>
    </div>

    <!-- 底部操作栏 -->
    <div class="footer">
      <el-button type="primary" @click="submitForm" class="submit-btn">提交申请</el-button>
    </div>
  </div>
</template>

<script>
  import { addVisitByApp } from "@/api/business/visit";

  export default {
    name: "VisitForm",
    data() {
      return {
        form: {
          uuid: null,
          name: null,
          phoneNumber: null,
          workplace: null,
          idNumber: null,
          licensePlate: null,
          parkingTime: null,
          department: null,
          interviewee: null,
          reason: null,
          visitDate: null,
          delFlag: null,
          remark: null,
          status: null
        },
        rules: {
          name: [
            { required: true, message: "姓名不能为空", trigger: "blur" }
          ],
          phoneNumber: [
            { required: true, message: "手机号不能为空", trigger: "blur" },
            { pattern: /^1[3-9]\d{9}$/, message: "请输入有效的手机号", trigger: "blur" }
          ],
          visitDate: [
            { required: true, message: "请选择访问日期", trigger: "change" }
          ]
        }
      };
    },
    methods: {
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            addVisitByApp(this.form).then(response => {
              this.$modal.msgSuccess("申请成功");
              this.reset();
            });
          }
        });
      },
      reset() {
        this.form = {
          uuid: null,
          name: null,
          phoneNumber: null,
          workplace: null,
          idNumber: null,
          licensePlate: null,
          parkingTime: null,
          department: null,
          interviewee: null,
          reason: null,
          visitDate: null,
        };
        this.$refs["form"].resetFields();
      }
    }
  };
</script>

<style scoped>
  .app-container {
    background-color: #f5f5f5;
    min-height: 100vh;
    padding: 20px;
  }

  .header {
    background-color: #1a73e8;
    color: white;
    text-align: center;
    padding: 30px 20px;
    border-radius: 12px;
    margin-bottom: 20px;
  }

  .header h1 {
    font-size: 24px;
    font-weight: bold;
    margin: 0;
  }

  .header p {
    font-size: 14px;
    margin: 5px 0 0;
    color: rgba(255, 255, 255, 0.8);
  }

  .form-container {
    background-color: white;
    border-radius: 12px;
    padding: 20px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  }

  .visit-form .el-form-item {
    margin-bottom: 20px;
  }

  .visit-form .el-form-item__label {
    font-weight: bold;
    color: #333;
  }

  .footer {
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: white;
    padding: 15px 20px;
    box-shadow: 0 -2px 10px rgba(0, 0, 0, 0.1);
    text-align: center;
  }

  .submit-btn {
    background-color: #1a73e8;
    color: white;
    width: 100%;
    max-width: 400px;
    font-size: 16px;
    padding: 12px 0;
    border-radius: 8px;
    transition: background-color 0.3s ease;
  }

  .submit-btn:hover {
    background-color: #1557b0;
  }

  @media (max-width: 768px) {
    .header {
      padding: 20px 15px;
    }

    .header h1 {
      font-size: 20px;
    }

    .header p {
      font-size: 12px;
    }

    .form-container {
      padding: 15px;
    }

    .submit-btn {
      font-size: 14px;
      padding: 10px 0;
    }
  }
</style>
