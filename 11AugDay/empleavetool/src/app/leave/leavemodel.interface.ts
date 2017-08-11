export interface LeaveModel {
  // leaveId
   empId: string ;
 fromDate: Date;
  // lastModifyTime
  reason: string;
  noDays: number;
  leaveTag: string;
  /*leaveStatus: string;*/
  toDate: Date;
}
