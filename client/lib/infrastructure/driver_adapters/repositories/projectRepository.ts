import axiosInstance from '@/lib/config/axiosConfig';
import { ProjectGateway } from '@/lib/domain/model/gateways/projectGatewat';
import { Project } from '@/lib/domain/model/project';
import { User } from '@/lib/domain/model/user';

export default class ProjectRepository implements ProjectGateway {
  private axios = axiosInstance;

  constructor() {}

  async getTaskByProject(project: Project): Promise<{ error?: any }> {
    try {
      await this.axios.post(`/api/v1/users/getProjectByUserId`, {
        project,
      });
      return {};
    } catch (error) {
      console.log(error);

      throw error;
    }
  }

  async getProjectsByUser(user: User): Promise<{ data: number[] }> {
    try {
      const { data } = await this.axios.post(
        `/api/v1/users/getProjectByUserId`,
        {
          email: user.email,
        }
      );

      return data;
    } catch (error) {
      console.log(error);

      throw error;
    }
  }
  async createNewProject(project: Project): Promise<{ error?: any }> {
    throw new Error('Method not implemented.');
  }
  editProject(project: Project): Promise<{ error?: any }> {
    throw new Error('Method not implemented.');
  }
}
