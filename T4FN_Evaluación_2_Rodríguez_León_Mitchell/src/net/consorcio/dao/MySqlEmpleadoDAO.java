package net.consorcio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.consorcio.entidad.Empleado;
import net.consorcio.interfaces.EmpleadoDAO;
import net.consorcio.utils.MySqlBDConexion;

public class MySqlEmpleadoDAO implements EmpleadoDAO {

	@Override
	public int save(Empleado bean) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlBDConexion.getConexion();
			String sql = "Insert into tb_empleado values(null, ?, ?, ?, ?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getApellido());
			pstm.setInt(3, bean.getDni());
			pstm.setInt(4, bean.getNhijos());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int delete(int codigo) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlBDConexion.getConexion();
			String sql = "Delete from tb_empleado where cod_empleado = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<Empleado> listAll() {
		List<Empleado> lista = new ArrayList<Empleado>();
		Empleado bean = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql = "Select * from tb_empleado";
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Empleado();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellido(rs.getString(3));
				bean.setDni(rs.getInt(4));
				bean.setNhijos(rs.getInt(5));
				lista.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int update(Empleado bean) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MySqlBDConexion.getConexion();
			String sql = "update tb_empleado set nom_empleado = ?, ape_empleado = ?, dni_empleado = ?, num_hijos = ?"; 
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getApellido());
			pstm.setInt(3, bean.getDni());
			pstm.setInt(4, bean.getNhijos());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public Empleado findEmpleado(int codigo) {
		Empleado bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="Select * from tb_empleado where cod_empleado=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			rs=pstm.executeQuery();
			if(rs.next()) {
				bean=new Empleado();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setApellido(rs.getString(3));
				bean.setDni(rs.getInt(4));
				bean.setNhijos(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}
}
